package com.dw.yacc;

public class constant {
	
	public static String YYMAJOR="1.0";
	public static String YYMINOR="1.0";
	public static String YYPATCH="1.0";
	
	public static String banner[] =
		{
		    "#ifndef lint",
		    "static const char yysccsid[] = \"@(#)yaccpar	1.9 (Berkeley) 02/21/93\";",
		    "#endif",
		    "",
		    "#define YYBYACC 1",
		    String.format("#define YYMAJOR %s", YYMAJOR),
		    String.format("#define YYMINOR %s", YYMINOR),
		    String.format("#define YYPATCH %s", YYPATCH),
		    "",
		    "#define YYEMPTY        (-1)",
		    "#define yyclearin      (yychar = YYEMPTY)",
		    "#define yyerrok        (yyerrflag = 0)",
		    "#define YYRECOVERING() (yyerrflag != 0)",
		    ""
		};

}
