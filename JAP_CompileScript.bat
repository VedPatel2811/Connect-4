:: ---------------------------------------------------------------------
:: JAP COURSE - SCRIPT
:: SCRIPT CST8221 - Fall 2023
:: ---------------------------------------------------------------------
:: Begin of Script (Labs - W24)
:: ---------------------------------------------------------------------

CLS

:: LOCAL VARIABLES ....................................................

:: Some of the below variables will need to be changed.
:: Remember to always use RELATIVE paths.

:: If your code needs no external libraries, remove all references to LIBDIR
:: in this script.

SET LIBDIR=lib
SET SRCDIR=src
SET BINDIR=bin
SET BINERR=labs-javac.err
SET JARNAME=out\production\Connect-4\Connect-4.jar
SET JAROUT=labs-jar.out
SET JARERR=labs-jar.err
SET DOCDIR=doc
SET DOCPACK=CST8221
SET DOCERR=labs-javadoc.err
SET MAINCLASSSRC=src\Main.java
SET MAINCLASSBIN=bin\Main.class

@echo off

ECHO "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
ECHO "@                                                                   @"
ECHO "@                   #       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  @"
ECHO "@                  ##       @  A L G O N Q U I N  C O L L E G E  @  @"
ECHO "@                ##  #      @    JAVA APPLICATION PROGRAMMING    @  @"
ECHO "@             ###    ##     @         F A L L  -  2 0 2 3        @  @"
ECHO "@          ###    ##        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  @"
ECHO "@        ###    ##                                                  @"
ECHO "@        ##    ###                 ###                              @"
ECHO "@         ##    ###                ###                              @"
ECHO "@           ##    ##               ###   #####  ##     ##  #####    @"
ECHO "@         (     (      ((((()      ###       ## ###   ###      ##   @"
ECHO "@     ((((     ((((((((     ()     ###   ######  ###  ##   ######   @"
ECHO "@        ((                ()      ###  ##   ##   ## ##   ##   ##   @"
ECHO "@         ((((((((((( ((()         ###   ######    ###     ######   @"
ECHO "@         ((         ((           ###                               @"
ECHO "@          (((((((((((                                              @"
ECHO "@   (((                      ((                                     @"
ECHO "@    ((((((((((((((((((((() ))                                      @"
ECHO "@         ((((((((((((((((()                                        @"
ECHO "@                                                                   @"
ECHO "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"

ECHO "[LABS SCRIPT ---------------------]"

ECHO "1. Compiling ......................"
javac -Xlint -cp ".;%SRCDIR%;%LIBDIR%/*" %MAINCLASSSRC% -d %BINDIR% 2> %BINERR%

ECHO "2. Creating Jar ..................."
cd %BINDIR%
jar cvfe %JARNAME% %MAINCLASSBIN% . > ../%JAROUT% 2> ../%JARERR%
cd ..

ECHO "3. Creating Javadoc ..............."
javadoc -cp ".;%BINDIR%;%LIBDIR%/*" --module-path "%LIBDIR%" -d %DOCDIR% -sourcepath %SRCDIR% -subpackages %DOCPACK% 2> %DOCERR%

ECHO "4. Running Jar ...................."
java --module-path "%LIBDIR%" -jar %JARNAME%


ECHO "[END OF SCRIPT -------------------]"
ECHO "                                   "
@echo on

:: ---------------------------------------------------------------------
:: End of Script (Labs - W24)
:: ---------------------------------------------------------------------
