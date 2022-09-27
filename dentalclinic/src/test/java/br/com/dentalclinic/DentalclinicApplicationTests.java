package br.com.dentalclinic;

import br.com.dentalclinic.service.ClinicaServiceImplTest;
import br.com.dentalclinic.service.ConsultaServiceImplTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({
//        ClinicaServiceImplTest.class
//})
class DentalclinicApplicationTests {


    @Test public void run() {
        JUnitCore.runClasses(ClinicaServiceImplTest.class, ConsultaServiceImplTest.class);
    }
//    public static void main(String[] args){
//        Result result = JUnitCore.runClasses(UnitTestSuite.class);
//
//        for (Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//
//        System.out.println(result.wasSuccessful());
//    }

}
