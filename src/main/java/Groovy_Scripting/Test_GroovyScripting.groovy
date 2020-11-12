package Groovy_Scripting
class Test_GroovyScripting {
    static Test_GroovyScripting test_groovyScripting;
    def xml;
    def filePath = "src/main/resources/utility_Properties/flatFile.txt";
    def filePath1 = "src/main/resources/utility_Properties/flatFile1.txt";

    static void main(String[] args) {
        test_groovyScripting = new Test_GroovyScripting();
        test_groovyScripting.compareFiles();
    }

    def getI(def str){
        def range = 0..5;
        println(range + "" + str)

       new File(filePath).eachLine {
            line -> println "line : $line";
        };

        new File().withWriter("utf-8",){
            writer -> writer.writeLine'MONDAY GROOVY'
        }
        this.xml = 239;
    }

    def compareFiles(){
        def src = new File(filePath);
        def dst = new File(filePath1);
        dst << src.text;
    }

}
