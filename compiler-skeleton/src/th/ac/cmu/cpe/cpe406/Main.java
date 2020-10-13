package th.ac.cmu.cpe.cpe406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import th.ac.cmu.cpe.cpe406.ast.Program;
import th.ac.cmu.cpe.cpe406.frontend.Source;
import th.ac.cmu.cpe.cpe406.frontend.Source_c;
import th.ac.cmu.cpe.cpe406.lex.Lexer;
import th.ac.cmu.cpe.cpe406.lex.Lexer_c;
import th.ac.cmu.cpe.cpe406.lex.Token;
import th.ac.cmu.cpe.cpe406.parse.Grm;
import th.ac.cmu.cpe.cpe406.parse.sym;
import th.ac.cmu.cpe.cpe406.util.ErrorInfo;
import th.ac.cmu.cpe.cpe406.util.ErrorQueue;
import th.ac.cmu.cpe.cpe406.util.CPE406ErrorQueue;

public class Main {

    public static void main(String[] args) {
        List<String> filenames = new LinkedList<>();
        boolean lex = false;
        boolean parse = false;
        boolean typecheck = false;
        String target = null;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
            case "--help":
                usage();
                return;
            case "--lex":
                lex = true;
                break;
            case "--parse":
                parse = true;
                break;
            case "--typecheck":
                typecheck = true;
                break;
            case "-target":
                if (i == args.length - 1) {
                    System.err.println("Missing argument");
                    usage(System.err);
                    return;
                }
                target = args[++i];
                switch (target) {
                case "linux":
                    break;
                default: {
                    System.err.println("Unrecognized target: " + target);
                    usage(System.err);
                    return;
                }
                }
                break;
            default:
                if (arg.startsWith("-")) {
                    System.err.println("Invalid option: " + arg);
                    usage(System.err);
                    return;
                }
                filenames.add(arg);
                break;
            }
        }

        for (String filename : filenames) {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File " + filename + " not exists.");
                continue;
            }
            try (Reader r = new FileReader(file);
                 BufferedReader br = new BufferedReader(r)) {
                String filenameNoExt =
                        filename.substring(0, filename.lastIndexOf('.'));
                File lexedFile =
                        lex ? new File(filenameNoExt + ".lexed") : null;
                try (FileWriter lexedfw =
                        lex ? new FileWriter(lexedFile) : null;
                     BufferedWriter lexedbw =
                             lex ? new BufferedWriter(lexedfw) : null;
                     FileWriter typedfw = typecheck
                             ? new FileWriter(filenameNoExt + ".typed") : null;
                     PrintWriter typedpw =
                             typecheck ? new PrintWriter(typedfw) : null) {
                    // Create an error queue
                    ErrorQueue eq = new CPE406ErrorQueue(System.out,
                                                      100,
                                                      "261406 compiler",
                                                      typedpw);
                    // Create a lexer
                    Lexer lexer =
                            new Lexer_c(br,
                                        new Source_c(file,
                                                     Source.Kind.USER_SPECIFIED),
                                        eq,
                                        lexedbw);
                    Program ast = null;
                    try (FileWriter parsedfw = parse
                            ? new FileWriter(filenameNoExt + ".parsed") : null;
                         PrintWriter parsedpw =
                                 parse ? new PrintWriter(parsedfw) : null;) {
                        // Create a parser
                        Grm parser = new Grm(lexer, eq, parsedpw);
                        ast = parser.parse().<Program> value();
                    }
                    catch (RuntimeException e) {
                        throw e;
                    }
                    catch (Exception e) {
                        // Used by CUP to indicate an unrecoverable error.
                        String msg = e.getMessage();
                        if (msg != null)
                            eq.enqueue(ErrorInfo.SYNTAX_ERROR, msg);
                    }
                    if (lex) {
                        // Output remaining tokens, if any.
                        for (Token tok = lexer.nextToken(); tok != null
                                && tok.symbol() != sym.EOF; tok =
                                        lexer.nextToken());
                    }

                    eq.flush();
                }
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void usage() {
        usage(System.out);
    }

    protected static void usage(PrintStream ps) {
        ps.println("Usage: xic [options] <source files>");
        ps.println("where possible options include:");
        ps.println("  --help\tPrint a synopsis of options");
        ps.println("  --lex\t\tGenerate output from lexical analysis");
        ps.println("  --parse\t\tGenerate output from syntactic analysis");
    }
}
