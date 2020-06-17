package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.stereotype.Component;



@Component(value ="Marca")
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Marca {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Marca
public static Var cadastrar() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return Var.VAR_NULL;
   }
 }.call();
}

}

