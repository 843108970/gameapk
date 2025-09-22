package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import java.io.PrintStream;
import java.util.Vector;
import javax.mail.internet.ParameterList;

public class BODYSTRUCTURE implements Item {
    private static int MULTI = 2;
    private static int NESTED = 3;
    private static int SINGLE = 1;
    static final char[] name = {'B', 'O', 'D', 'Y', 'S', 'T', 'R', 'U', 'C', 'T', 'U', 'R', 'E'};
    private static boolean parseDebug = false;
    public String attachment;
    public BODYSTRUCTURE[] bodies;
    public ParameterList cParams;
    public ParameterList dParams;
    public String description;
    public String disposition;
    public String encoding;
    public ENVELOPE envelope;
    public String id;
    public String[] language;
    public int lines = -1;
    public String md5;
    public int msgno;
    private int processedType;
    public int size = -1;
    public String subtype;
    public String type;

    static {
        try {
            String property = System.getProperty("mail.imap.parse.debug");
            parseDebug = property != null && property.equalsIgnoreCase("true");
        } catch (SecurityException unused) {
        }
    }

    public BODYSTRUCTURE(FetchResponse fetchResponse) throws ParsingException {
        if (parseDebug) {
            System.out.println("DEBUG IMAP: parsing BODYSTRUCTURE");
        }
        this.msgno = fetchResponse.getNumber();
        if (parseDebug) {
            PrintStream printStream = System.out;
            printStream.println("DEBUG IMAP: msgno " + this.msgno);
        }
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() != 40) {
            throw new ParsingException("BODYSTRUCTURE parse error: missing ``('' at start");
        } else if (fetchResponse.peekByte() == 40) {
            if (parseDebug) {
                System.out.println("DEBUG IMAP: parsing multipart");
            }
            this.type = "multipart";
            this.processedType = MULTI;
            Vector vector = new Vector(1);
            do {
                vector.addElement(new BODYSTRUCTURE(fetchResponse));
                fetchResponse.skipSpaces();
            } while (fetchResponse.peekByte() == 40);
            this.bodies = new BODYSTRUCTURE[vector.size()];
            vector.copyInto(this.bodies);
            this.subtype = fetchResponse.readString();
            if (parseDebug) {
                PrintStream printStream2 = System.out;
                printStream2.println("DEBUG IMAP: subtype " + this.subtype);
            }
            if (fetchResponse.readByte() != 41) {
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: parsing extension data");
                }
                this.cParams = parseParameters(fetchResponse);
                if (fetchResponse.readByte() != 41) {
                    byte readByte = fetchResponse.readByte();
                    if (readByte == 40) {
                        if (parseDebug) {
                            System.out.println("DEBUG IMAP: parse disposition");
                        }
                        this.disposition = fetchResponse.readString();
                        if (parseDebug) {
                            PrintStream printStream3 = System.out;
                            printStream3.println("DEBUG IMAP: disposition " + this.disposition);
                        }
                        this.dParams = parseParameters(fetchResponse);
                        if (fetchResponse.readByte() != 41) {
                            throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition in multipart");
                        } else if (parseDebug) {
                            System.out.println("DEBUG IMAP: disposition DONE");
                        }
                    } else if (readByte == 78 || readByte == 110) {
                        if (parseDebug) {
                            System.out.println("DEBUG IMAP: disposition NIL");
                        }
                        fetchResponse.skip(2);
                    } else {
                        throw new ParsingException("BODYSTRUCTURE parse error: " + this.type + "/" + this.subtype + ": bad multipart disposition, b " + readByte);
                    }
                    byte readByte2 = fetchResponse.readByte();
                    if (readByte2 == 41) {
                        if (parseDebug) {
                            System.out.println("DEBUG IMAP: no body-fld-lang");
                        }
                    } else if (readByte2 != 32) {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing space after disposition");
                    } else {
                        if (fetchResponse.peekByte() == 40) {
                            this.language = fetchResponse.readStringList();
                            if (parseDebug) {
                                PrintStream printStream4 = System.out;
                                printStream4.println("DEBUG IMAP: language len " + this.language.length);
                            }
                        } else {
                            String readString = fetchResponse.readString();
                            if (readString != null) {
                                this.language = new String[]{readString};
                                if (parseDebug) {
                                    PrintStream printStream5 = System.out;
                                    printStream5.println("DEBUG IMAP: language " + readString);
                                }
                            }
                        }
                        while (fetchResponse.readByte() == 32) {
                            parseBodyExtension(fetchResponse);
                        }
                    }
                } else if (parseDebug) {
                    System.out.println("DEBUG IMAP: body parameters DONE");
                }
            } else if (parseDebug) {
                System.out.println("DEBUG IMAP: parse DONE");
            }
        } else {
            if (parseDebug) {
                System.out.println("DEBUG IMAP: single part");
            }
            this.type = fetchResponse.readString();
            if (parseDebug) {
                PrintStream printStream6 = System.out;
                printStream6.println("DEBUG IMAP: type " + this.type);
            }
            this.processedType = SINGLE;
            this.subtype = fetchResponse.readString();
            if (parseDebug) {
                PrintStream printStream7 = System.out;
                printStream7.println("DEBUG IMAP: subtype " + this.subtype);
            }
            if (this.type == null) {
                this.type = "application";
                this.subtype = "octet-stream";
            }
            this.cParams = parseParameters(fetchResponse);
            if (parseDebug) {
                PrintStream printStream8 = System.out;
                printStream8.println("DEBUG IMAP: cParams " + this.cParams);
            }
            this.id = fetchResponse.readString();
            if (parseDebug) {
                PrintStream printStream9 = System.out;
                printStream9.println("DEBUG IMAP: id " + this.id);
            }
            this.description = fetchResponse.readString();
            if (parseDebug) {
                PrintStream printStream10 = System.out;
                printStream10.println("DEBUG IMAP: description " + this.description);
            }
            this.encoding = fetchResponse.readString();
            if (parseDebug) {
                PrintStream printStream11 = System.out;
                printStream11.println("DEBUG IMAP: encoding " + this.encoding);
            }
            this.size = fetchResponse.readNumber();
            if (parseDebug) {
                PrintStream printStream12 = System.out;
                printStream12.println("DEBUG IMAP: size " + this.size);
            }
            if (this.size < 0) {
                throw new ParsingException("BODYSTRUCTURE parse error: bad ``size'' element");
            }
            if (this.type.equalsIgnoreCase("text")) {
                this.lines = fetchResponse.readNumber();
                if (parseDebug) {
                    PrintStream printStream13 = System.out;
                    printStream13.println("DEBUG IMAP: lines " + this.lines);
                }
                if (this.lines < 0) {
                    throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                }
            } else if (!this.type.equalsIgnoreCase("message") || !this.subtype.equalsIgnoreCase("rfc822")) {
                fetchResponse.skipSpaces();
                if (Character.isDigit((char) fetchResponse.peekByte())) {
                    throw new ParsingException("BODYSTRUCTURE parse error: server erroneously included ``lines'' element with type " + this.type + "/" + this.subtype);
                }
            } else {
                this.processedType = NESTED;
                this.envelope = new ENVELOPE(fetchResponse);
                this.bodies = new BODYSTRUCTURE[]{new BODYSTRUCTURE(fetchResponse)};
                this.lines = fetchResponse.readNumber();
                if (parseDebug) {
                    PrintStream printStream14 = System.out;
                    printStream14.println("DEBUG IMAP: lines " + this.lines);
                }
                if (this.lines < 0) {
                    throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                }
            }
            if (fetchResponse.peekByte() == 41) {
                fetchResponse.readByte();
                if (parseDebug) {
                    System.out.println("DEBUG IMAP: parse DONE");
                    return;
                }
                return;
            }
            this.md5 = fetchResponse.readString();
            if (fetchResponse.readByte() != 41) {
                byte readByte3 = fetchResponse.readByte();
                if (readByte3 == 40) {
                    this.disposition = fetchResponse.readString();
                    if (parseDebug) {
                        PrintStream printStream15 = System.out;
                        printStream15.println("DEBUG IMAP: disposition " + this.disposition);
                    }
                    this.dParams = parseParameters(fetchResponse);
                    if (parseDebug) {
                        PrintStream printStream16 = System.out;
                        printStream16.println("DEBUG IMAP: dParams " + this.dParams);
                    }
                    if (fetchResponse.readByte() != 41) {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition");
                    }
                } else if (readByte3 == 78 || readByte3 == 110) {
                    if (parseDebug) {
                        System.out.println("DEBUG IMAP: disposition NIL");
                    }
                    fetchResponse.skip(2);
                } else {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.type + "/" + this.subtype + ": bad single part disposition, b " + readByte3);
                }
                if (fetchResponse.readByte() != 41) {
                    if (fetchResponse.peekByte() == 40) {
                        this.language = fetchResponse.readStringList();
                        if (parseDebug) {
                            PrintStream printStream17 = System.out;
                            printStream17.println("DEBUG IMAP: language len " + this.language.length);
                        }
                    } else {
                        String readString2 = fetchResponse.readString();
                        if (readString2 != null) {
                            this.language = new String[]{readString2};
                            if (parseDebug) {
                                PrintStream printStream18 = System.out;
                                printStream18.println("DEBUG IMAP: language " + readString2);
                            }
                        }
                    }
                    while (fetchResponse.readByte() == 32) {
                        parseBodyExtension(fetchResponse);
                    }
                    if (parseDebug) {
                        System.out.println("DEBUG IMAP: all DONE");
                    }
                } else if (parseDebug) {
                    System.out.println("DEBUG IMAP: disposition DONE");
                }
            } else if (parseDebug) {
                System.out.println("DEBUG IMAP: no MD5 DONE");
            }
        }
    }

    private void parseBodyExtension(Response response) throws ParsingException {
        response.skipSpaces();
        byte peekByte = response.peekByte();
        if (peekByte == 40) {
            response.skip(1);
            do {
                parseBodyExtension(response);
            } while (response.readByte() != 41);
        } else if (Character.isDigit((char) peekByte)) {
            response.readNumber();
        } else {
            response.readString();
        }
    }

    private ParameterList parseParameters(Response response) throws ParsingException {
        response.skipSpaces();
        byte readByte = response.readByte();
        if (readByte == 40) {
            ParameterList parameterList = new ParameterList();
            do {
                String readString = response.readString();
                if (parseDebug) {
                    PrintStream printStream = System.out;
                    printStream.println("DEBUG IMAP: parameter name " + readString);
                }
                if (readString == null) {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.type + "/" + this.subtype + ": null name in parameter list");
                }
                String readString2 = response.readString();
                if (parseDebug) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("DEBUG IMAP: parameter value " + readString2);
                }
                parameterList.set(readString, readString2);
            } while (response.readByte() != 41);
            parameterList.set((String) null, "DONE");
            return parameterList;
        } else if (readByte == 78 || readByte == 110) {
            if (parseDebug) {
                System.out.println("DEBUG IMAP: parameter list NIL");
            }
            response.skip(2);
            return null;
        } else {
            throw new ParsingException("Parameter list parse error");
        }
    }

    public boolean isMulti() {
        return this.processedType == MULTI;
    }

    public boolean isNested() {
        return this.processedType == NESTED;
    }

    public boolean isSingle() {
        return this.processedType == SINGLE;
    }
}
