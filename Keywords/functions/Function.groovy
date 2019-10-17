package functions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Function {
	@Keyword
	public static void Pause5sec() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Keyword
	public static void Pause10sec() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Keyword
	public static void Pause20sec() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Keyword
	public static void Pause40sec() {
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Keyword
	public static void Pause1min() {
		try {
			Thread.sleep(70000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Keyword
	public String pass() {
		String s = "ab";
		return s = s.concat("cd");
	}

	//random name
	@Keyword
	public String novoNome() {
		String chars = "abcdefghijklmnopqrstuvxyz";
		Random rnd = new Random();
		char c = chars.charAt(rnd.nextInt(chars.length()));
		String str2 = "Nome";
		String str1 = str2.concat(String.valueOf(c));
		return str1;
	}

	@Keyword
	public String novoSobrenome() {
		String chars = "abcdefghijklmnopqrstuvxyz";
		Random rnd = new Random();
		char c = chars.charAt(rnd.nextInt(chars.length()));
		String str2 = "Sobrenome";
		String sob = str2.concat(String.valueOf(c));

		return sob;
	}

	//randomEmail
	@Keyword
	public String emailGenerator() {
		Random rnd = new Random();
		String str = "";
		String str1 = "";
		String sob = "";
		int supName = 0;

		for (int i = 0; i < 10; i++) {
			supName = (rnd.nextInt(99));
			String str2 = "teste";
			str = String.valueOf(supName);
			str1 = str2.concat(str);
		}
		for (int i = 0; i < 10; i++) {
			supName = (rnd.nextInt(100));
			String str2 = "@teste.io";
			str = String.valueOf(supName);
			sob = str.concat(str2);
		}

		return str1.concat(sob);
	}
	public static class CPF {

		public String generate() {

			Random r = new Random();

			StringBuilder sbCpfNumber = new StringBuilder();

			for (int i = 0; i < 9; i++) {

				sbCpfNumber.append(r.nextInt(9));

			}

			return generateDigits(sbCpfNumber.toString());

		}

		public boolean validateCPF(String cpf) {

			if (cpf.length() == 11) {

				if (cpf.equals(generateDigits(cpf.substring(0, 9)))) {

					return true;
				}
			}
			return false;
		}

		private String generateDigits(String digitsBase) {

			StringBuilder sbCpfNumber = new StringBuilder(digitsBase);

			int total = 0;

			int multiple = digitsBase.length() + 1;

			for (char digit : digitsBase.toCharArray()) {

				long parcial = Integer.parseInt(String.valueOf(digit)) * (multiple--);

				total += parcial;
			}

			int resto = Integer.parseInt(String.valueOf(Math.abs(total % 11)));

			if (resto < 2) {
				resto = 0;
			} else {
				resto = 11 - resto;
			}

			sbCpfNumber.append(resto);

			if (sbCpfNumber.length() < 11) {
				return generateDigits(sbCpfNumber.toString());
			}
			return sbCpfNumber.toString();
		}
	}
	@Keyword
	public String CPF() {
		CPF myCPF = new CPF();
		String cpf = myCPF.generate();
		return cpf;
	}
}
