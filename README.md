IntelijIdea
Apache Maven
jdk v.11
src/main/com.mystore/: apis, ui, utils
src/test/com.mystore: apis, base, tests
src/test/resources: config file, chrome driver & mystoreTests.xml the suite tests (UI & API)
pom.xml contains all the necessary dependencies used in the framework to cover UI & APIs, for CI/CD future integration


git clone (locally)
mvn clean
mvn install
run Tests using mystoreTests.xml, or test by test from tests package
