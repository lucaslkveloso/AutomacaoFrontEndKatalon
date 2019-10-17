import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Abre o Browser
WebUI.openBrowser('')

//Navega para URL
WebUI.navigateToUrl('http://www.automationpractice.com')

//Maximiza o Browser
WebUI.maximizeWindow()

//Seleciona primeiro produto da home
WebUI.waitForElementPresent(findTestObject('Object Repository/Home/DivProduto1'), 20)
WebUI.focus(findTestObject('Object Repository/Home/DivProduto1'))
WebUI.click(findTestObject('Object Repository/Home/ButtonAddCart'))

//Avança do modal de confirmação para o checkout
WebUI.waitForElementVisible(findTestObject('Object Repository/Home/ButtonModalProceed'), 10)
WebUI.click(findTestObject('Object Repository/Home/ButtonModalProceed'))

//Valida se o produto selecionado foi incluido com sucesso
WebUI.waitForElementPresent(findTestObject('Object Repository/Checkout/ProdutoCarrinho'), 10)
WebUI.verifyTextPresent('Faded Short Sleeve T-shirts', false)

//Avança para próxima etapa
WebUI.click(findTestObject('Object Repository/Checkout/ButtonCartProceed'))

//Insere email para criação de uma nova conta
WebUI.waitForElementClickable(findTestObject('Object Repository/Account/InputCreateAccount'), 10)
WebUI.sendKeys(findTestObject('Object Repository/Account/InputCreateAccount'), CustomKeywords.'functions.Function.emailGenerator'())
WebUI.click(findTestObject('Object Repository/Account/ButtonCreateAccount'))

//Seleciona titularidade
WebUI.click(findTestObject('Object Repository/Account/RadioTitle'))

//Insere Nome e sobre nome
WebUI.sendKeys(findTestObject('Object Repository/Account/InputFirstName'), CustomKeywords.'functions.Function.novoNome'())
WebUI.sendKeys(findTestObject('Object Repository/Account/InputLastName'), CustomKeywords.'functions.Function.novoSobrenome'())

//Valida padrão de email
WebUI.click(findTestObject('Object Repository/Account/InputEmail'))
WebUI.sendKeys(findTestObject('Object Repository/Account/InputEmail'), Keys.chord(Keys.TAB))

//Insere nova senha
WebUI.sendKeys(findTestObject('Object Repository/Account/InputPassword'), "senhateste")

//Seleciona data de nascimento
WebUI.selectOptionByValue(findTestObject('Object Repository/Account/SelectDay'), '16', false)
WebUI.selectOptionByValue(findTestObject('Object Repository/Account/SelectMonth'), '10', false)
WebUI.selectOptionByValue(findTestObject('Object Repository/Account/SelectYear'), '1995', false)

//Dados de endereço
WebUI.sendKeys(findTestObject('Object Repository/Account/InputCompany'), "Teste")

//Endereço
WebUI.sendKeys(findTestObject('Object Repository/Account/InputAdress'), "Street 10")
WebUI.sendKeys(findTestObject('Object Repository/Account/InputCity'), "New Haven")

WebUI.selectOptionByValue(findTestObject('Object Repository/Account/SelectState'), '7', false)

WebUI.sendKeys(findTestObject('Object Repository/Account/InputPostalCode'), "70150")

//Informa Telefone
WebUI.sendKeys(findTestObject('Object Repository/Account/InputMobilePhone'), "09111115150")

//Confirma os dados e registra usuário
WebUI.click(findTestObject('Object Repository/Account/ButtonRegister'))

//Valida se o produto selecionado foi incluido com sucesso
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/ButtonProceedAdress'), 10)
WebUI.verifyTextPresent('New Haven, Connecticut 70150', false)
WebUI.click(findTestObject('Object Repository/Checkout/ButtonProceedAdress'))

//Valida termos e avança
WebUI.click(findTestObject('Object Repository/Checkout/CheckboxTerm'))
WebUI.click(findTestObject('Checkout/ButtonCheckoutShipping'))

//Calcula valores
String productx = WebUI.getText(findTestObject('Object Repository/Checkout/ValueProduct'))
String shippingx = WebUI.getText(findTestObject('Object Repository/Checkout/ValueShipping'))
String totalx = WebUI.getText(findTestObject('Object Repository/Checkout/TotalValue'))

double product = Double.parseDouble(productx.substring(1,6))
double shipping = Double.parseDouble(shippingx.substring(1,5))
double checktotal = product + shipping
double total = Double.parseDouble(totalx.substring(1,6))

//Valida se os valores do carrinho estão corretos
WebUI.verifyEqual(total, checktotal)

//Seleciona opção de pagamento
WebUI.click(findTestObject('Object Repository/Checkout/ButtonPaybyBank'))

//Confirma pagamento
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/ButtonConfirmation'), 10)
WebUI.click(findTestObject('Object Repository/Checkout/ButtonConfirmation'))

//Verifica se a compra foi finalizada
WebUI.waitForElementVisible(findTestObject('Object Repository/Checkout/TextConfirmationOrder'), 10)

//Fecha o Browser
WebUI.closeBrowser()

