set projectLocation=refs/remotes/origin/master/SalesForce/SalesForce/
cd %projectLocation%
set classpath=%projectLocation%\bin;C:\Java_jar\*
java org.testng.TestNG %projectLocation%\Leads.xml
pause