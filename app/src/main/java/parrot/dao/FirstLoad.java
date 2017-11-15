package parrot.dao;

import android.content.ContentValues;

import java.util.ArrayList;

/**
 * Created by Windows on 24/10/2017.
 */

public class FirstLoad {

    public ArrayList<ContentValues> frases = new ArrayList<>();

    public ArrayList<ContentValues> firstInsert() {

        /* INGLES
           0 - VIAGENS
           1 - ALIMENTACAO
           2 - COMUM
           3 - SAUDE

           ALEMAO
           5 - VIAGENS
           6 - ALIMENTACAO
           7 - COMUM
           8- SAUDE
         */

        //VIAGENS
        ContentValues cv01 = new ContentValues();
        cv01.put("original", "Quanto eu devo pagar por excesso de peso?");
        cv01.put("traducao", "How much do I have to pay for excess weight?");
        cv01.put("categoria","viagens");
        cv01.put("favorito", "false");
        cv01.put("idiomaOriginal","portugues");
        cv01.put("idiomaTraducao","ingles");
        frases.add(cv01);

        ContentValues cv02 = new ContentValues();
        cv02.put("original", "Você tem algum quarto livre?");
        cv02.put("traducao", "Do you have any room available?");
        cv02.put("categoria","viagens");
        cv02.put("favorito", "false");
        cv02.put("idiomaOriginal","portugues");
        cv02.put("idiomaTraducao","ingles");
        frases.add(cv02);

        ContentValues cv03 = new ContentValues();
        cv03.put("original", "Este vôo é direto?");
        cv03.put("traducao", "Is this flight non-stop?");
        cv03.put("categoria","viagens");
        cv03.put("favorito", "false");
        cv03.put("idiomaOriginal","portugues");
        cv03.put("idiomaTraducao","ingles");
        frases.add(cv03);


        ContentValues cv04 = new ContentValues();
        cv04.put("original", "Quanto é por dia?");
        cv04.put("traducao", "How much per day?");
        cv04.put("categoria","viagens");
        cv04.put("favorito", "false");
        cv04.put("idiomaOriginal","portugues");
        cv04.put("idiomaTraducao","ingles");
        frases.add(cv04);

        ContentValues cv05 = new ContentValues();
        cv05.put("original", "Eu gostaria de fazer o check in, por favor?");
        cv05.put("traducao", "I would like to check in, please?");
        cv05.put("categoria","viagens");
        cv05.put("favorito", "false");
        cv05.put("idiomaOriginal","portugues");
        cv05.put("idiomaTraducao","ingles");
        frases.add(cv05);


        ContentValues cv06 = new ContentValues();
        cv06.put("original", "Eu gostaria de fazer o check out, por favor?");
        cv06.put("traducao", "I would like to check out, please?");
        cv06.put("categoria","viagens");
        cv06.put("favorito", "false");
        cv06.put("idiomaOriginal","portugues");
        cv06.put("idiomaTraducao","ingles");
        frases.add(cv06);



        ContentValues cv51 = new ContentValues();
        cv51.put("original", "Quanto eu devo pagar por excesso de peso?");
        cv51.put("traducao", "Wie viel muss ich fur Lbergewicht bezohler?");
        cv51.put("categoria","viagens");
        cv51.put("favorito", "false");
        cv51.put("idiomaOriginal","portugues");
        cv51.put("idiomaTraducao","alemao");
        frases.add(cv51);

        ContentValues cv52 = new ContentValues();
        cv52.put("original", "Você tem algum quarto livre?");
        cv52.put("traducao", "Hast du ein zimmer?");
        cv52.put("categoria","viagens");
        cv52.put("favorito", "false");
        cv52.put("idiomaOriginal","portugues");
        cv52.put("idiomaTraducao","alemao");
        frases.add(cv52);

        ContentValues cv53 = new ContentValues();
        cv53.put("original", "Este vôo é direto?");
        cv53.put("traducao", "Ist dieser Flug nonstop?");
        cv53.put("categoria","viagens");
        cv53.put("favorito", "false");
        cv53.put("idiomaOriginal","portugues");
        cv53.put("idiomaTraducao","alemao");
        frases.add(cv53);


        ContentValues cv54 = new ContentValues();
        cv54.put("original", "Quanto é por dia?");
        cv54.put("traducao", "Wie viel pro tag?");
        cv54.put("categoria","viagens");
        cv54.put("favorito", "false");
        cv54.put("idiomaOriginal","portugues");
        cv54.put("idiomaTraducao","alemao");
        frases.add(cv54);

        ContentValues cv55 = new ContentValues();
        cv55.put("original", "Eu gostaria de fazer o check in, por favor?");
        cv55.put("traducao", "Ich würde einchecken, Bitte?");
        cv55.put("categoria","viagens");
        cv55.put("favorito", "false");
        cv55.put("idiomaOriginal","portugues");
        cv55.put("idiomaTraducao","alemao");
        frases.add(cv55);


        ContentValues cv56 = new ContentValues();
        cv56.put("original", "Eu gostaria de fazer o check out, por favor?");
        cv56.put("traducao", "Ich würde auschecken, Bitte?");
        cv56.put("categoria","viagens");
        cv56.put("favorito", "false");
        cv56.put("idiomaOriginal","portugues");
        cv56.put("idiomaTraducao","alemao");
        frases.add(cv56);


        //ALIMENTACAO

        ContentValues cv11 = new ContentValues();
        cv11.put("original", "Eu gostaria de fazer meu pedido, por favor?");
        cv11.put("traducao", "I would like to order, please?");
        cv11.put("categoria","alimentacao");
        cv11.put("favorito", "false");
        cv11.put("idiomaOriginal","portugues");
        cv11.put("idiomaTraducao","ingles");
        frases.add(cv11);

        ContentValues cv12 = new ContentValues();
        cv12.put("original", "A conta, por favor?");
        cv12.put("traducao", "The bill, please?");
        cv12.put("categoria","alimentacao");
        cv12.put("favorito", "false");
        cv12.put("idiomaOriginal","portugues");
        cv12.put("idiomaTraducao","ingles");
        frases.add(cv12);

        ContentValues cv14 = new ContentValues();
        cv14.put("original", "Eu não gosto de comida apimentada");
        cv14.put("traducao", "I don't like spicy food");
        cv14.put("categoria","alimentacao");
        cv14.put("favorito", "false");
        cv14.put("idiomaOriginal","portugues");
        cv14.put("idiomaTraducao","ingles");
        frases.add(cv14);

        ContentValues cv15 = new ContentValues();
        cv15.put("original", "Eu gostaria de uma cerveja");
        cv15.put("traducao", "I would like a beer");
        cv15.put("categoria","alimentacao");
        cv15.put("favorito", "false");
        cv15.put("idiomaOriginal","portugues");
        cv15.put("idiomaTraducao","ingles");
        frases.add(cv15);

        ContentValues cv16 = new ContentValues();
        cv16.put("original", "Eu vou querer macarrão, por favor");
        cv16.put("traducao", "I'll have pasta, please");
        cv16.put("categoria","alimentacao");
        cv16.put("favorito", "false");
        cv16.put("idiomaOriginal","portugues");
        cv16.put("idiomaTraducao","ingles");
        frases.add(cv16);


        ContentValues cv61 = new ContentValues();
        cv61.put("original", "Eu gostaria de fazer meu pedido, por favor?");
        cv61.put("traducao", "Ich würde gerne bestellen, Bitte?");
        cv61.put("categoria","alimentacao");
        cv61.put("favorito", "false");
        cv61.put("idiomaOriginal","portugues");
        cv61.put("idiomaTraducao","alemao");
        frases.add(cv61);

        ContentValues cv62 = new ContentValues();
        cv62.put("original", "A conta, por favor?");
        cv62.put("traducao", "Die Rechnung, Bitte?");
        cv62.put("categoria","alimentacao");
        cv62.put("favorito", "false");
        cv62.put("idiomaOriginal","portugues");
        cv62.put("idiomaTraducao","alemao");
        frases.add(cv62);

        ContentValues cv64 = new ContentValues();
        cv64.put("original", "Eu não gosto de comida apimentada");
        cv64.put("traducao", "Ich mag kein würzug essen");
        cv64.put("categoria","alimentacao");
        cv64.put("favorito", "false");
        cv64.put("idiomaOriginal","portugues");
        cv64.put("idiomaTraducao","alemao");
        frases.add(cv64);

        ContentValues cv65 = new ContentValues();
        cv65.put("original", "Eu gostaria de uma cerveja");
        cv65.put("traducao", "Ich möchte ein Bier haber");
        cv65.put("categoria","alimentacao");
        cv65.put("favorito", "false");
        cv65.put("idiomaOriginal","portugues");
        cv65.put("idiomaTraducao","alemao");
        frases.add(cv65);

        ContentValues cv66 = new ContentValues();
        cv66.put("original", "Eu vou querer macarrão, por favor");
        cv66.put("traducao", "Ich möchte die nudeln haber, Bitte?");
        cv66.put("categoria","alimentacao");
        cv66.put("favorito", "false");
        cv66.put("idiomaOriginal","portugues");
        cv66.put("idiomaTraducao","alemao");
        frases.add(cv66);


        //COMUM
        ContentValues cv21 = new ContentValues();
        cv21.put("original", "Onde posso encontrar um ponto de taxi?");
        cv21.put("traducao", "Where can I find a cab stand?");
        cv21.put("categoria","comum");
        cv21.put("favorito", "false");
        cv21.put("idiomaOriginal","portugues");
        cv21.put("idiomaTraducao","ingles");
        frases.add(cv21);

        ContentValues cv22 = new ContentValues();
        cv22.put("original", "Vocês aceitam cartão de crédito?");
        cv22.put("traducao", "Do you take credit card?");
        cv22.put("categoria","comum");
        cv22.put("favorito", "false");
        cv22.put("idiomaOriginal","portugues");
        cv22.put("idiomaTraducao","ingles");
        frases.add(cv22);

        ContentValues cv23 = new ContentValues();
        cv23.put("original", "Qual a senha para conectar na wifi?");
        cv23.put("traducao", "What's the password to connect the wifi?");
        cv23.put("categoria","comum");
        cv23.put("favorito", "false");
        cv23.put("idiomaOriginal","portugues");
        cv23.put("idiomaTraducao","ingles");
        frases.add(cv23);

        ContentValues cv24 = new ContentValues();
        cv24.put("original", "Você tem troco?");
        cv24.put("traducao", "Do you have change?");
        cv24.put("categoria","comum");
        cv24.put("favorito", "false");
        cv24.put("idiomaOriginal","portugues");
        cv24.put("idiomaTraducao","ingles");
        frases.add(cv24);

        ContentValues cv25 = new ContentValues();
        cv25.put("original", "Quanto custa isso?");
        cv25.put("traducao", "How much this costs?");
        cv25.put("categoria","comum");
        cv25.put("favorito", "false");
        cv25.put("idiomaOriginal","portugues");
        cv25.put("idiomaTraducao","ingles");
        frases.add(cv25);

        ContentValues cv26 = new ContentValues();
        cv26.put("original", "Quanto é pela corrida?");
        cv26.put("traducao", "How much for the ride?");
        cv26.put("categoria","comum");
        cv26.put("favorito", "false");
        cv26.put("idiomaOriginal","portugues");
        cv26.put("idiomaTraducao","ingles");
        frases.add(cv26);


        ContentValues cv71 = new ContentValues();
        cv71.put("original", "Onde posso encontrar um ponto de taxi?");
        cv71.put("traducao", "Wo finde ich einen taxi stand?");
        cv71.put("categoria","comum");
        cv71.put("favorito", "false");
        cv71.put("idiomaOriginal","portugues");
        cv71.put("idiomaTraducao","alemao");
        frases.add(cv71);

        ContentValues cv72 = new ContentValues();
        cv72.put("original", "Vocês aceitam cartão de crédito?");
        cv72.put("traducao", "Akzeptieren Sie Kreditkarte?");
        cv72.put("categoria","comum");
        cv72.put("favorito", "false");
        cv72.put("idiomaOriginal","portugues");
        cv72.put("idiomaTraducao","alemao");
        frases.add(cv72);

        ContentValues cv73 = new ContentValues();
        cv73.put("original", "Qual a senha para conectar na wifi?");
        cv73.put("traducao", "Welche is das passwort um des wi-fi wie verbinden?");
        cv73.put("categoria","comum");
        cv73.put("favorito", "false");
        cv73.put("idiomaOriginal","portugues");
        cv73.put("idiomaTraducao","alemao");
        frases.add(cv73);

        ContentValues cv74 = new ContentValues();
        cv74.put("original", "Você tem troco?");
        cv74.put("traducao", "Hast die geldwechsel?");
        cv74.put("categoria","comum");
        cv74.put("favorito", "false");
        cv74.put("idiomaOriginal","portugues");
        cv74.put("idiomaTraducao","alemao");
        frases.add(cv74);

        ContentValues cv75 = new ContentValues();
        cv75.put("original", "Quanto custa isso?");
        cv75.put("traducao", "Wie viel kost es?");
        cv75.put("categoria","comum");
        cv75.put("favorito", "false");
        cv75.put("idiomaOriginal","portugues");
        cv75.put("idiomaTraducao","alemao");
        frases.add(cv75);

        ContentValues cv76 = new ContentValues();
        cv76.put("original", "Quanto é pela corrida?");
        cv76.put("traducao", "Wie viel kostet die Fahrt?");
        cv76.put("categoria","comum");
        cv76.put("favorito", "false");
        cv76.put("idiomaOriginal","portugues");
        cv76.put("idiomaTraducao","alemao");
        frases.add(cv76);



        //SAUDE
        ContentValues cv31 = new ContentValues();
        cv31.put("original", "Eu acho que estou com conjuntivite");
        cv31.put("traducao", "I think I have pink eye");
        cv31.put("categoria","saude");
        cv31.put("favorito", "false");
        cv31.put("idiomaOriginal","portugues");
        cv31.put("idiomaTraducao","ingles");
        frases.add(cv31);

        ContentValues cv32 = new ContentValues();
        cv32.put("original", "Eu tenho pressão alta");
        cv32.put("traducao", "I have high blood pressure");
        cv32.put("categoria","saude");
        cv32.put("favorito", "false");
        cv32.put("idiomaOriginal","portugues");
        cv32.put("idiomaTraducao","ingles");
        frases.add(cv32);

        ContentValues cv33 = new ContentValues();
        cv33.put("original", "Eu tenho que tomar minha injeção de insulina");
        cv33.put("traducao", "I have to take my insuline shot");
        cv33.put("categoria","saude");
        cv33.put("favorito", "false");
        cv33.put("idiomaOriginal","portugues");
        cv33.put("idiomaTraducao","ingles");
        frases.add(cv33);

        ContentValues cv34 = new ContentValues();
        cv34.put("original", "Eu sou alérgico a dipirona");
        cv34.put("traducao", "I'm allergic to dipyrone");
        cv34.put("categoria","saude");
        cv34.put("favorito", "false");
        cv34.put("idiomaOriginal","portugues");
        cv34.put("idiomaTraducao","ingles");
        frases.add(cv34);

        ContentValues cv35 = new ContentValues();
        cv35.put("original", "Eu tenho diabetes");
        cv35.put("traducao", "I have diabetes");
        cv35.put("categoria","saude");
        cv35.put("favorito", "false");
        cv35.put("idiomaOriginal","portugues");
        cv35.put("idiomaTraducao","ingles");
        frases.add(cv35);


        ContentValues cv36 = new ContentValues();
        cv36.put("original", "Eu estou com febre");
        cv36.put("traducao", "I have a fever");
        cv36.put("categoria","saude");
        cv36.put("favorito", "false");
        cv36.put("idiomaOriginal","portugues");
        cv36.put("idiomaTraducao","ingles");
        frases.add(cv36);


        ContentValues cv81 = new ContentValues();
        cv81.put("original", "Eu acho que estou com conjuntivite");
        cv81.put("traducao", "Ich glaub, ich habe Konjunktivitis");
        cv81.put("categoria","saude");
        cv81.put("favorito", "false");
        cv81.put("idiomaOriginal","portugues");
        cv81.put("idiomaTraducao","alemao");
        frases.add(cv81);

        ContentValues cv82 = new ContentValues();
        cv82.put("original", "Eu tenho pressão alta");
        cv82.put("traducao", "Ich habe Bluthochdruck");
        cv82.put("categoria","saude");
        cv82.put("favorito", "false");
        cv82.put("idiomaOriginal","portugues");
        cv82.put("idiomaTraducao","alemao");
        frases.add(cv82);

        ContentValues cv83 = new ContentValues();
        cv83.put("original", "Eu tenho que tomar minha injeção de insulina");
        cv83.put("traducao", "Ich muss meine Insulin Injektion nehmen");
        cv83.put("categoria","saude");
        cv83.put("favorito", "false");
        cv83.put("idiomaOriginal","portugues");
        cv83.put("idiomaTraducao","alemao");
        frases.add(cv83);

        ContentValues cv84 = new ContentValues();
        cv84.put("original", "Eu sou alérgico a dipirona");
        cv84.put("traducao", "Ich bin allergisch gegen Dipyrone");
        cv84.put("categoria","saude");
        cv84.put("favorito", "false");
        cv84.put("idiomaOriginal","portugues");
        cv84.put("idiomaTraducao","alemao");
        frases.add(cv84);

        ContentValues cv85 = new ContentValues();
        cv85.put("original", "Eu tenho diabetes");
        cv85.put("traducao", "Ich habe diabetes");
        cv85.put("categoria","saude");
        cv85.put("favorito", "false");
        cv85.put("idiomaOriginal","portugues");
        cv85.put("idiomaTraducao","alemao");
        frases.add(cv85);


        ContentValues cv86 = new ContentValues();
        cv86.put("original", "Eu estou com febre");
        cv86.put("traducao", "Ich habe fieber");
        cv86.put("categoria","saude");
        cv86.put("favorito", "false");
        cv86.put("idiomaOriginal","portugues");
        cv86.put("idiomaTraducao","alemao");
        frases.add(cv86);




        return frases;
    }

}
