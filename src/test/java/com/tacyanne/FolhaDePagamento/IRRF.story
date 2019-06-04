Narrative:
As  Funcionario
I want inserir valor do salario
So that obter valores de Desconto

Scenario:  Calcular InssIrrf I
 
Given Salario  Bruto de 1000.00
Then o salario liquido sera o  920.00

Scenario:  Calcular InssIrrf II

Given Salario  Bruto de 2000.00
Then o salario liquido sera o  1812.80


Scenario:  Calcular InssIrrf III 

Given Salario  Bruto de 3000.00
Then o salario liquido sera o  2574.80


Scenario:  Calcular InssIrrf IV 

Given Salario  Bruto de 4000.00
Then o salario liquido sera o  3296.13

Scenario:  Calcular InssIrrf IV 550

Given Salario  Bruto de 5000.00
Then o salario liquido sera o  3944.36