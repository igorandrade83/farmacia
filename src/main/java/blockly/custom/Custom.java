package blockly.custom;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import cronapi.CronapiMetaData;
import cronapi.ParamMetaData;
import cronapi.Var;


/**
 * Arrendonda um número para duas casas decimais ...
 *
 * @author Samuel Almeida
 * @version 1.0
 * @since 2020-07-20
 *
 */

@CronapiMetaData(categoryName = "Custom")
public class Custom {

	@CronapiMetaData(type = "function", name = "formatar para valor real", description = "Formata um valor real para duas casas decimais")
	public static Var formatRealValue(@ParamMetaData(description = "Valor: Descrição do parâmetro") Var number) throws Exception {
		
		try {
			Double num = number.getObjectAsDouble();
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
			decimalFormat.setRoundingMode(RoundingMode.DOWN);
			return Var.valueOf(decimalFormat.format(num));
		} catch (Exception e) {
			System.out.print("Erro ao formatar número");
		}

		return number;

	}

}