package com.tacyanne.FolhaDePagamento;

import model.FolhaDePagamento;
import model.FolhaDePagamento;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class CalcInssIRRF extends Steps {


	public CalcInssIRRF() {

	}
	FolhaDePagamento folha = new FolhaDePagamento();

	@Given("Salario  Bruto de $salariobruto")
	public void popularValorEJuros(@Named("salariobruto") double salariobruto) {
		folha.setSalariobruto(salariobruto);

	}

	@Then("o salario liquido sera o $salarioliquido")
	public void investimentoTest(@Named("salarioliquido") double salarioliquido){
            
		assertEquals(salarioliquido, folha.calcularSalarioLiquido(), 0);

	}

}
