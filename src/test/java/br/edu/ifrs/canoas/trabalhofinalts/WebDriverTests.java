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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverTests {
    private static WebDriver chromeDriver;
    private static WebDriverWait wait;
    private static final String URL = "https://testesoftwarecanoas.000webhostapp.com/mapos/";
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
                chromeDriver.findElement(By.xpath("//*[@id=\"user-nav\"]/ul/li[1]/a/span")).getText()
        );
        
        assertEquals(
                "Sair do Sistema", 
                chromeDriver.findElement(By.xpath("//*[@id=\"user-nav\"]/ul/li[2]/a/span")).getText()
        );
        
        assertTrue(chromeDriver.findElement(
                By.xpath("//*[@id=\"user-nav\"]/ul/li[3]/a/span")
        ).getText().contains("Versão:"));
        
        //Verificando barra lateral
        assertEquals(
                "Clientes", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/a/span")).getText()
        );
        
        assertEquals(
                "Produtos", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/a/span")).getText()
        );
        
        assertEquals(
                "Serviços", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/a/span")).getText()
        );
        
        assertEquals(
                "Ordens de Serviço", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/a/span")).getText()
        );
        
        assertEquals(
                "Vendas", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/a/span")).getText()
        );
        
        assertEquals(
                "Arquivos", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[7]/a/span")).getText()
        );
        
        assertEquals(
                "Financeiro", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[8]/a/span[1]")).getText()
        );
        
        assertEquals(
                "Relatórios", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[9]/a/span[1]")).getText()
        );
        
        assertEquals(
                "Configurações", 
                chromeDriver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[10]/a/span[1]")).getText()
        );
        
        //Verificação da parte superior central
        assertEquals(
                "Clientes", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[1]/a")).getText()
        );
        
        assertEquals(
                "Produtos", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[2]/a")).getText()
        );
        
        assertEquals(
                "Serviços", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[3]/a")).getText()
        );
        
        assertEquals(
                "OS", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[4]/a")).getText()
        );
        
        assertEquals(
                "Vendas", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div/ul/li[5]/a")).getText()
        );
    }
    
    @Test
    @Ignore
    public void cdu3P(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        assertEquals("Adicionar Cliente",
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/a")).getText()
        );
        
        assertEquals("Próxima",
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/ul/li[4]/a")).getText()
        );
        
        assertTrue(chromeDriver.findElement(
                By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table")
        ) != null);
        
        assertEquals("#", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/thead/tr/th[1]")).getText()
        );
        
        assertEquals("Nome", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/thead/tr/th[2]")).getText()
        );
        
        assertEquals("CPF/CNPJ", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/thead/tr/th[3]")).getText()
        );
        
        assertEquals("Telefone", 
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/thead/tr/th[4]")).getText()
        );
        
        assertEquals("icon-eye-open",
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[1]/i")).getAttribute("class")
        );
        
        assertEquals("icon-pencil icon-white",
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[2]/i")).getAttribute("class")
        );
        
        assertEquals("icon-remove icon-white",
                chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[3]/i")).getAttribute("class")
        );
    }
    
    @Test
    @Ignore
    public void cdu3a1(){
        access("//*[@id=\"sidebar\"]/ul/li[2]/a");
        
        //Pega a primeira linha da tabela
        String row = "//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]";
        
        Map<String, String> columns = new HashMap<>();
        
        columns.put("nome", chromeDriver.findElement(By.xpath(row+"/td[2]")).getText());
        columns.put("telefone", chromeDriver.findElement(By.xpath(row+"/td[4]")).getText());
        
        //Clica no botão Visualizar
        chromeDriver.findElement(
                By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a[1]")
        ).click();
        
        waitFor("//*[@id=\"breadcrumb\"]/a[3]");
        
        //Verificando a aba Dados do Cliente
        WebElement tab = chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[1]/ul/li[1]/a"));
        assertTrue(tab != null);
        
        //Verificando a seção Dados Pessoais
        WebElement section = chromeDriver.findElement(By.xpath("//*[@id=\"collapse-group\"]/div[1]/div[1]/div/a/h5"));
        assertTrue(section != null);
        
        assertEquals(columns.get("nome"),
                chromeDriver.findElement(By.xpath("//*[@id=\"collapseGOne\"]/div/table/tbody/tr[1]/td[2]")).getText()
        );
        
        //Verificando a seção Contatos
        section = chromeDriver.findElement(By.xpath("//*[@id=\"collapse-group\"]/div[2]/div[1]/div/a/h5"));
        assertTrue(section != null);
        
        section.click();
        
        waitFor("//*[@id=\"collapseGTwo\"]/div/table/tbody");
        
        assertEquals(columns.get("telefone"),
                chromeDriver.findElement(By.xpath("//*[@id=\"collapseGTwo\"]/div/table/tbody/tr[1]/td[2]")).getText()
        );
        
        //Verificando a seção Endereço
        section = chromeDriver.findElement(By.xpath("//*[@id=\"collapse-group\"]/div[3]/div[1]/div/a/h5"));
        assertTrue(section != null);
        
        assertTrue(chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[1]/ul/div/a")) != null);
        
        //Verificando a aba Ordens de Serviço
        tab = chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[1]/ul/li[2]/a"));
        assertTrue(tab != null);
        
        tab.click();
        
        waitFor("//*[@id=\"tab2\"]/table");
        
        assertTrue(chromeDriver.findElement(By.xpath("//*[@id=\"tab2\"]/table")) != null);
        
        assertTrue(chromeDriver.findElement(
                By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[1]/ul/div/a")
        ) != null);
    }
    
    @Test
    public void cdu3a2(){
        
    }
    
    @Test
    public void cdu3a3(){
        
    }
    
    @Test
    public void cdu4P(){
        
    }
    
    @Test
    public void cdu4a1(){
        
    }
    
    @Test
    public void cdu4a2(){
        
    }
    
    @Test
    public void cdu4a3(){
        
    }
    
    @Test
    public void cdu4a4(){
        
    }
    
    @Test
    public void cdu5P(){
        
    }
    
    @Test
    public void cdu5a1(){
        
    }
    
    @Test
    public void cdu5a2(){
        
    }
    
    @Test
    public void cdu5a3(){
        
    }
    
    @Test
    public void cdu5a4(){
        
    }
    
    @Test
    public void cdu6P(){
        access("//*[@id=\"sidebar\"]/ul/li[3]/a/span");
    }
    
    @Test
    public void cdu6a1(){
        
    }
    
    @Test
    public void cdu6a2(){
        
    }
    
    @Test
    public void cdu6a3(){
        
    }
    
    @Test
    public void cdu7P(){
        
    }
    
    @Test
    public void cdu7a1(){
        
    }
    
    @Test
    public void cdu7a2(){
        
    }
    
    @Test
    public void cdu7a3(){
        
    }
    
    @Test
    public void cdu8P(){
        
    }
    
    @Test
    public void cdu8a1(){
        
    }
    
    @Test
    public void cdu8a2(){
        
    }
    
    @Test
    public void cdu8a3(){
        
    }
    
    public void login(String email, String password){
        chromeDriver.get(URL);
        chromeDriver.findElement(By.name("email")).sendKeys(email);
        chromeDriver.findElement(By.name("senha")).sendKeys(password);
        chromeDriver.findElement(By.id("btn-acessar")).click();
    }
    
    public WebElement waitFor(String xpath){
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(xpath)
        ));
    }
    
    public void access(String xpath){
        login(EMAIL, PASSWORD);
        
        waitFor("//*[@id=\"breadcrumb\"]/a[1]");
        
        chromeDriver.findElement(By.xpath(xpath)).click();
        
        waitFor("//*[@id=\"breadcrumb\"]/a[2]");
    }
}