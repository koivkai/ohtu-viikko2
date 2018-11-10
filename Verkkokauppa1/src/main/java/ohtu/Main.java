package ohtu;

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");
        
        
        Kirjanpito kirjanpito      = (Kirjanpito) ctx.getBean("kirjanpito");
//        Varasto varasto            = ctx.getBean(Varasto.class);
//        Pankki pankki              = ctx.getBean(Pankki.class);
//        Viitegeneraattori viitegen = ctx.getBean(Viitegeneraattori.class);
        Kauppa kauppa              = (Kauppa) ctx.getBean("kauppa");


        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
//    <bean id="kirjanpito" class="ohtu.verkkokauppa.Kirjanpito">
//    </bean>
//    
//    <bean id="viitegeneraattori" class="ohtu.verkkokauppa.Viitegeneraattori">
//    </bean>
//
//    <bean id="varasto" class="ohtu.verkkokauppa.Varasto">
//        <constructor-arg ref="kirjanpito" />
//    </bean>
//    
//    <bean id="pankki" class="ohtu.verkkokauppa.Pankki">
//        <constructor-arg ref="kirjanpito" />
//    </bean>
//    
//    <bean id="kauppa" class="ohtu.verkkokauppa.Kauppa">
//        <constructor-arg ref="varasto" />
//        <constructor-arg ref="pankki" />
//        <constructor-arg ref="viitegeneraattori" />
//    </bean>
}

