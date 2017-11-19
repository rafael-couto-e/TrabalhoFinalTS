package br.edu.ifrs.canoas.trabalhofinalts;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverTests {
    private static WebDriver chromeDriver;
    private static WebDriverWait wait;
    private static JavascriptExecutor jse;
    private static final String URL = "https://testesoftwarecanoas.000webhostapp.com/mapos/index.php/mapos/login";
    private static final String EMAIL = "ts03@admin.com";
    private static final String PASSWORD = "123456";
    
    public WebDriverTests() {
    }
    
    @BeforeClass
    public static void init(){
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir")+File.separator+"chromedriver"
        );
        
        chromeDriver = new ChromeDriver();
        
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(chromeDriver, 30);
        jse = (JavascriptExecutor) chromeDriver;
    }
    
    @AfterClass
    public static void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        chromeDriver.quit();
    }
    
    @Test
    @Ignore
    public void cdu1p(){
        login(EMAIL, PASSWORD);
        
        String homeUrl = "https://testesoftwarecanoas.000webhostapp.com/mapos/index.php/mapos";
        
        waitFor("//*[@id=\"breadcrumb\"]/a[1]");
        
        assertEquals(homeUrl, chromeDriver.getCurrentUrl());
    }
    
    @Test
    @Ignore
    public void cdu1a1(){
        login(EMAIL, "");
        
        WebElement element = waitFor("//*[@id=\"formLogin\"]/div[3]/div/div/span[2]");
        
        assertEquals("Campo Requerido.", element.getText());
    }
    
    @Test
    @Ignore
    public void cdu1a2(){
        login(EMAIL, "1234567");
        
        WebElement element = waitFor("//*[@id=\"notification\"]/div[2]/h5");
        
        assertEquals(
                "Os dados de acesso estão incorretos, por favor tente novamente!",
                element.getText()
        );
    }
    
    @Test
    @Ignore
    public void cdu1a3(){
        login("ts03.admin.com", PASSWORD);
        
        WebElement element = waitFor("//*[@id=\"formLogin\"]/div[2]/div/div/span[2]");
        
        assertEquals("Insira Email válido", element.getText());
    }
    
    @Test
    @Ignore
    public void cdu2P(){
        login(EMAIL, PASSWORD);
        
        waitFor("//*[@id=\"breadcrumb\"]/a[1]");
        
        //Verificando barra superior
        assertEquals(
                "Minha Conta", 
                getTextFromElement("//*[@id=\"user-nav\"]/ul/li[1]/a/span")
        );
        
        assertEquals(
                "Sair do Sistema", 
                getTextFromElement("//*[@id=\"user-nav\"]/ul/li[2]/a/span")
        );
        
        assertTrue(getTextFromElement("//*[@id=\"user-nav\"]/ul/li[3]/a/span").contains("Versão:"));
        
        //Verificando barra lateral
        assertEquals(
                "Clientes", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[2]/a/span")
        );
        
        assertEquals(
                "Produtos", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[3]/a/span")
        );
        
        assertEquals(
                "Serviços", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[4]/a/span")
        );
        
        assertEquals(
                "Ordens de Serviço", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[5]/a/span")
        );
        
        assertEquals(
                "Vendas", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[6]/a/span")
        );
        
        assertEquals(
                "Arquivos", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[7]/a/span")
        );
        
        assertEquals(
                "Financeiro", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[8]/a/span[1]")
        );
        
        assertEquals(
                "Relatórios", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[9]/a/span[1]")
        );
        
        assertEquals(
                "Configurações", 
                getTextFromElement("//*[@id=\"sidebar\"]/ul/li[10]/a/span[1]")
        );
        
        //Verificação da parte superior central
        assertEquals(
                "Clientes", 
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[1]/a")
        );
        
        assertEquals(
                "Produtos", 
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[2]/a")
        );
        
        assertEquals(
                "Serviços", 
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[3]/a")
        );
        
        assertEquals(
                "OS", 
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[4]/a")
        );
        
        assertEquals(
                "Vendas", 
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[5]/a")
        );
    }
    
    @Test
    @Ignore
    public void cdu3P(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        assertEquals("Adicionar Cliente",
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/a")
        );
        
        assertEquals("Próxima",
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div[2]/ul/li[4]/a")
        );
        
        assertTrue(find(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table")) != null);
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/thead/tr";
        
        assertEquals("#", 
                getTextFromElement(row+"/th[1]")
        );
        
        assertEquals("Nome", 
                getTextFromElement(row+"/th[2]")
        );
        
        assertEquals("CPF/CNPJ", 
                getTextFromElement(row+"/th[3]")
        );
        
        assertEquals("Telefone", 
                getTextFromElement(row+"/th[4]")
        );
        
        row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]";
        
        assertEquals("icon-eye-open",
                getAttributeFromElement(row+"/a[1]/i", "class")
        );
        
        assertEquals("icon-pencil icon-white",
                getAttributeFromElement(row+"/a[2]/i", "class")
        );
        
        assertEquals("icon-remove icon-white",
                getAttributeFromElement(row+"/a[3]/i", "class")
        );
    }
    
    @Test
    @Ignore
    public void cdu3a1(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]";
        
        Map<String, String> columns = 
                getClientInfo(row);
        
        //Clica no botão Visualizar
        click(row+"/td[5]/a[1]");
        
        waitFor("//*[@id=\"breadcrumb\"]/a[3]");
        
        //Verificando a aba Dados do Cliente
        WebElement tab = find(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[1]/ul/li[1]/a"));
        assertTrue(tab != null);
        
        //Verificando a seção Dados Pessoais
        WebElement section = find(By.xpath("//*[@id=\"collapse-group\"]/div[1]/div[1]/div/a/h5"));
        assertTrue(section != null);
        
        assertEquals(columns.get("nome"),
                getTextFromElement("//*[@id=\"collapseGOne\"]/div/table/tbody/tr[1]/td[2]")
        );
        
        //Verificando a seção Contatos
        section = find(By.xpath("//*[@id=\"collapse-group\"]/div[2]/div[1]/div/a/h5"));
        assertTrue(section != null);
        
        section.click();
        
        waitFor("//*[@id=\"collapseGTwo\"]/div/table/tbody");
        
        assertEquals(columns.get("telefone"),
                getTextFromElement("//*[@id=\"collapseGTwo\"]/div/table/tbody/tr[1]/td[2]")
        );
        
        //Verificando a seção Endereço
        section = find(By.xpath("//*[@id=\"collapse-group\"]/div[3]/div[1]/div/a/h5"));
        assertTrue(section != null);
        
        assertTrue(find(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[1]/ul/div/a")) != null);
        
        //Verificando a aba Ordens de Serviço
        tab = find(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[1]/ul/li[2]/a"));
        assertTrue(tab != null);
        
        tab.click();
        
        WebElement table = waitFor("//*[@id=\"tab2\"]/table");
        
        assertTrue(table != null);
        
        assertTrue(find(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[1]/ul/div/a")) != null);
    }
    
    @Test
    @Ignore
    public void cdu3a3(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]";
        
        Map<String, String> deletedColumns = getClientInfo(row);
        
        click(row+"/td[5]/a[3]");
        
        waitFor("//*[@id=\"modal-excluir\"]/form");
        
        WebElement delete = waitForVisibility("//*[@id=\"modal-excluir\"]/form/div[3]/button[2]");
        
        delete.click();
        
        waitFor("//*[@id=\"breadcrumb\"]/a[3]");
        
        assertTrue(getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div[1]").contains("Cliente excluido com sucesso!"));
        
        row = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/table/tbody/tr[1]";
        
        Map<String, String> columns = getClientInfo(row);
        
        assertNotEquals(deletedColumns.get("numero"), columns.get("numero"));
    }
    
    @Test
    @Ignore
    public void cdu4P(){
        addClient("p");
        
        WebElement success = waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        assertTrue(success.getText().contains("Cliente adicionado com sucesso!"));
    }
    
    @Test
    @Ignore
    public void cdu4a1(){
        addClient("a1");
        
        waitFor("//*[@id=\"formCliente\"]/div[5]/div/span");
        
        assertEquals(
                "Campo Requerido.",
                getTextFromElement("//*[@id=\"formCliente\"]/div[5]/div/span")
        );
    }
    
    @Test
    @Ignore
    public void cdu4a2(){
        addClient("a2");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div/div[2]/div");
        
        assertEquals(
                "The Email field must contain a valid email address.",
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div/div/div/div[2]/div/div/p")
        );
    }
    
    @Test
    @Ignore
    public void cdu4a3(){
        addClient("a3");
        
        waitFor("//*[@id=\"breadcrumb\"]/a[3]");
        
        //Falha. Campo permite letras.
        assertEquals(
                "The CPF/CNPJ field must contain a numeric value.",
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div/div/div/div[2]/div/div/p")
        );
    }
    
    @Test
    @Ignore
    public void cdu4a4(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        click("//*[@id=\"content\"]/div[2]/div/div/a");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        WebElement back = waitToBeClickable("//*[@id=\"formCliente\"]/div[12]/div/div/a");
        
        scrollTo(back);
        
        back.click();
        
        assertEquals(
                "https://testesoftwarecanoas.000webhostapp.com/mapos/index.php/clientes",
                chromeDriver.getCurrentUrl()
        );
    }
    
    @Test
    @Ignore
    public void cdu5P(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]";
        String number = getTextFromElement(row+"/td[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[2]");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        String newName = "José da Silva";
        
        WebElement name = find(By.id("nomeCliente"));
        
        name.clear();
        name.sendKeys(newName);
        
        WebElement button = find(By.xpath("//*[@id=\"formCliente\"]/div[12]/div/div/button"));
        scrollTo(button);
        button.click();
        
        WebElement success = waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        assertTrue(success.getText().contains("Cliente editado com sucesso!"));
        
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        assertEquals(number, getTextFromElement(row+"/td[1]"));
        assertEquals(newName, getTextFromElement(row+"/td[2]"));
    }
    
    @Test
    @Ignore
    public void cdu5a1(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]";
        String number = getTextFromElement(row+"/td[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[2]");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        find(By.id("nomeCliente")).clear();
        
        WebElement button = find(By.xpath("//*[@id=\"formCliente\"]/div[12]/div/div/button"));        
        scrollTo(button);
        button.click();
        
        assertEquals("Campo Requerido.", getTextFromElement("//*[@id=\"formCliente\"]/div[1]/div/span"));
    }
    
    @Test
    @Ignore
    public void cdu5a2(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]";
        String number = getTextFromElement(row+"/td[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[2]");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        WebElement email = find(By.id("email"));
        
        email.clear();
        email.sendKeys("ts03.admin.com");
        
        WebElement button = find(By.xpath("//*[@id=\"formCliente\"]/div[12]/div/div/button"));        
        scrollTo(button);
        button.click();
        
        String error = "//*[@id=\"content\"]/div[2]/div/div/div/div/div/div[2]/div";
        
        waitFor(error);
        
        assertTrue(getTextFromElement(error+"/div/p").contains("The Email field must contain a valid email address."));
    }
    
    @Test
    @Ignore
    public void cdu5a3(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]";
        String number = getTextFromElement(row+"/td[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[2]");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        WebElement cpfcnpj = find(By.id("documento"));
        cpfcnpj.clear();
        cpfcnpj.sendKeys("AAAAAAAAAAA");
        
        WebElement button = find(By.xpath("//*[@id=\"formCliente\"]/div[12]/div/div/button"));
        scrollTo(button);
        button.click();
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div/div[2]/div");
        
        //Falha. Campo permite letras.
        assertEquals(
                "The CPF/CNPJ field must contain a numeric value.",
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div/div/div/div[2]/div/div/p")
        );
    }
    
    @Test
    @Ignore
    public void cdu5a4(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        WebElement form = waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[2]");
        click("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[2]");
        
        waitFor("//*[@id=\"formCliente\"]/div[12]/div/div/a");
        
        WebElement back = find(By.xpath("//*[@id=\"formCliente\"]/div[12]/div/div/a"));
        scrollTo(back);
        back.click();
        
        assertEquals(
                "https://testesoftwarecanoas.000webhostapp.com/mapos/index.php/clientes",
                chromeDriver.getCurrentUrl()
        );
    }
    
    @Test
    @Ignore
    public void cdu6P(){
        access("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        assertTrue(find(By.xpath("//*[@id=\"content\"]/div[2]/div/div/a")) != null);
        assertTrue(find(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/ul/li[4]/a")) != null);
        assertTrue(find(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table")) != null);
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/thead/tr";
        
        assertEquals("Nome", getTextFromElement(row+"/th[2]"));
        assertEquals("Estoque", getTextFromElement(row+"/th[3]"));
        assertEquals("Preço", getTextFromElement(row+"/th[4]"));
        
        row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]";
        
        assertEquals("icon-eye-open",
                getAttributeFromElement(row+"/a[1]/i", "class")
        );
        
        assertEquals("icon-pencil icon-white",
                getAttributeFromElement(row+"/a[2]/i", "class")
        );
        
        assertEquals("icon-remove icon-white",
                getAttributeFromElement(row+"/a[3]/i", "class")
        );
    }
    
    @Test
    @Ignore
    public void cdu6a1(){
        access("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        Map<String, String> columns = getProductInfo("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[1]");
        
        waitFor("//*[@id=\"collapse-group\"]/div");
        
        String table = "//*[@id=\"collapse-group\"]/div/div[2]/div/table/tbody";
        
        assertEquals("Descrição", getTextFromElement(table+"/tr[1]/td[1]"));
        assertEquals(columns.get("nome"), getTextFromElement(table+"/tr[1]/td[2]"));
        assertEquals("Unidade", getTextFromElement(table+"/tr[2]/td[1]"));        
        assertEquals("Preço de Compra", getTextFromElement(table+"/tr[3]/td[1]"));
        assertEquals("Preço de Venda", getTextFromElement(table+"/tr[4]/td[1]"));
        assertTrue(getTextFromElement(table+"/tr[4]/td[2]").contains(columns.get("preco")));
        assertEquals("Estoque", getTextFromElement(table+"/tr[5]/td[1]"));
        assertEquals(columns.get("estoque"), getTextFromElement(table+"/tr[5]/td[2]"));
        assertEquals("Estoque Mínimo", getTextFromElement(table+"/tr[6]/td[1]"));
        
        //Não vai passar, botão "voltar" não existe.
        WebElement back = find(By.xpath("//*[@id=\"collapse-group\"]/div/div[12]/div/div/a"));
        scrollTo(back);
        back.click();
        
        assertEquals(
                "https://testesoftwarecanoas.000webhostapp.com/mapos/index.php/produtos",
                chromeDriver.getCurrentUrl()
        );
    }
    
    @Test
    @Ignore
    public void cdu6a3(){
        access("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]";
        
        Map<String, String> columns = getProductInfo(row);
        
        click(row+"/td[5]/a[3]");
        
        WebElement button = waitForVisibility("//*[@id=\"modal-excluir\"]/form/div[3]/button[2]");
        
        button.click();
        
        WebElement success = waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        assertTrue(success.getText().contains("Produto excluido com sucesso!"));
        
        row = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/table/tbody/tr[1]";
        
        Map<String, String> newColumns = getProductInfo(row);
        
        assertNotEquals(newColumns.get("numero"), columns.get("numero"));
    }
    
    @Test
    @Ignore
    public void cdu7P(){
        access("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/a");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        find(By.id("descricao")).sendKeys("Produto Cadastrado 1");
        find(By.id("unidade")).sendKeys("kg");
        find(By.id("precoCompra")).sendKeys("80.00");
        find(By.id("precoVenda")).sendKeys("100.00");
        find(By.id("estoque")).sendKeys("100");
        find(By.id("estoqueMinimo")).sendKeys("20");
        
        click("//*[@id=\"formProduto\"]/div[7]/div/div/button");
        
        WebElement success = waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        assertTrue(success.getText().contains("Produto adicionado com sucesso!"));
    }
    
    @Test
    @Ignore
    public void cdu7a1(){
        access("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/a");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        find(By.id("descricao")).sendKeys("Produto Cadastrado 1");
        find(By.id("unidade")).sendKeys("kg");
        find(By.id("precoCompra")).sendKeys("80.00");
        find(By.id("estoque")).sendKeys("100");
        
        click("//*[@id=\"formProduto\"]/div[7]/div/div/button");
        
        WebElement error = waitFor("//*[@id=\"formProduto\"]/div[4]/div/span");
        
        assertEquals("Campo Requerido.", error.getText());
    }
    
    @Test
    @Ignore
    public void cdu7a2(){
        access("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/a");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        find(By.id("descricao")).sendKeys("Produto Cadastrado 1");
        find(By.id("unidade")).sendKeys("kg");
        find(By.id("precoCompra")).sendKeys("80.00");
        find(By.id("precoVenda")).sendKeys("2500.00");
        find(By.id("estoque")).sendKeys("AAA");
        
        click("//*[@id=\"formProduto\"]/div[7]/div/div/button");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div/div[2]/div");
        
        //Falha. Campo permite letras.
        assertEquals(
                "The Estoque field must contain a numeric value.",
                getTextFromElement("//*[@id=\"content\"]/div[2]/div/div/div/div/div/div[2]/div/div/p")
        );
    }
    
    @Test
    @Ignore
    public void cdu7a3(){
        access("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div[1]");
        
        click("//*[@id=\"content\"]/div[2]/div/div/a");
        
        WebElement back = waitFor("//*[@id=\"formProduto\"]/div[7]/div/div/a");
        scrollTo(back);
        back.click();
        
        waitFor("//*[@id=\"breadcrumb\"]/a[2]");
        
        assertEquals(
                "https://testesoftwarecanoas.000webhostapp.com/mapos/index.php/produtos",
                chromeDriver.getCurrentUrl()
        );
    }
    
    @Test
    @Ignore
    public void cdu8P(){
        
    }
    
    @Test
    @Ignore
    public void cdu8a1(){
        
    }
    
    @Test
    @Ignore
    public void cdu8a2(){
        
    }
    
    @Test
    @Ignore
    public void cdu8a3(){
        
    }
    
    public void login(String email, String password){
        chromeDriver.get(URL);
        find(By.name("email")).sendKeys(email);
        find(By.name("senha")).sendKeys(password);
        find(By.id("btn-acessar")).click();
    }
    
    public WebElement waitFor(String xpath){
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(xpath)
        ));
    }
    
    public void access(String xpath){
        login(EMAIL, PASSWORD);
        
        waitFor("//*[@id=\"breadcrumb\"]/a[1]");
        
        click(xpath);
        
        waitFor("//*[@id=\"breadcrumb\"]/a[2]");
    }
    
    public Map<String, String> getClientInfo(String row){
        Map<String, String> columns = new HashMap<>();
        
        columns.put("numero", find(By.xpath(row+"/td[1]")).getText());
        columns.put("nome", find(By.xpath(row+"/td[2]")).getText());
        columns.put("telefone", find(By.xpath(row+"/td[4]")).getText());
        
        return columns;
    }
    
    public Map<String, String> getProductInfo(String row){
        Map<String, String> columns = new HashMap<>();
        
        columns.put("numero", find(By.xpath(row+"/td[1]")).getText());
        columns.put("nome", find(By.xpath(row+"/td[2]")).getText());
        columns.put("estoque", find(By.xpath(row+"/td[3]")).getText());
        columns.put("preco", find(By.xpath(row+"/td[4]")).getText().replace(".", "").replace(",", "."));
        
        return columns;
    }
    
    public void click(String xpath){
        find(By.xpath(xpath)).click();
    }
    
    public WebElement find(By by){
        return chromeDriver.findElement(by);
    }
    
    public String getTextFromElement(String xpath){
        return find(By.xpath(xpath)).getText();
    }
    
    public String getAttributeFromElement(String xpath, String attribute){
        return find(By.xpath(xpath)).getAttribute(attribute);
    }
    
    public void addClient(String flux){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        click("//*[@id=\"content\"]/div[2]/div/div/a");
        
        waitFor("//*[@id=\"content\"]/div[2]/div/div/div/div/div");
        
        find(By.id("nomeCliente")).sendKeys("Rafael Couto Estrela");
        find(By.id("documento")).sendKeys("03720498000");
        find(By.id("telefone")).sendKeys("5137855297");
        find(By.id("celular")).sendKeys("51992152754");
        find(By.id("rua")).sendKeys("Fernão de Magalhães");
        find(By.id("numero")).sendKeys("235");
        find(By.id("bairro")).sendKeys("Harmonia");
        find(By.id("cidade")).sendKeys("Canoas");
        find(By.id("estado")).sendKeys("RS");
        find(By.id("cep")).sendKeys("92310450");
        
        switch(flux){
            case "p":
                find(By.id("email")).sendKeys("rcouto97@gmail.com");
                break;
            case "a2":
                find(By.id("email")).sendKeys("teste.admin.com");
                break;
            case "a3":
                WebElement cpfcnpj = find(By.id("documento"));
                cpfcnpj.clear();
                cpfcnpj.sendKeys("AAAAAAAAAAA");
                find(By.id("email")).sendKeys("rcouto97@gmail.com");
                break;
        }
        
        WebElement button = waitToBeClickable("//*[@id=\"formCliente\"]/div[12]/div/div/button");
        
        button.click();
    }

    private WebElement waitForVisibility(String xpath) {
        return wait.until(ExpectedConditions.visibilityOf(
                find(By.xpath(xpath))
        ));
    }
    
    private WebElement waitToBeClickable(String xpath){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    private void scrollTo(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView()", element);
    }
}