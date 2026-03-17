<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="ShareLaneAllTests" parallel="classes" thread-count="2">
    <test name="Registration">
        <classes><class name="tests.RegistrationTest"/></classes>
    </test>
    <test name="Login">
        <classes><class name="tests.LoginTest"/></classes>
    </test>
    <test name="Search">
        <classes><class name="tests.SearchTest"/></classes>
    </test>
    <test name="Cart">
        <classes><class name="tests.CartTest"/></classes>
    </test>
    <test name="BugReport">
        <classes><class name="tests.BugReportsTest"/></classes>
    </test>
</suite>