package src.dao;

import android.content.ContentValues;

import java.util.ArrayList;

/**
 * Created by Windows on 24/10/2017.
 */

public class FirstLoad {

    public ArrayList<ContentValues> frases = new ArrayList<>();

    public ArrayList<ContentValues> firstInsert() {

        /* 0 - VIAGENS
           1 - ALIMENTACAO
           2 - COMUM
           3 - SAUDE
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
        cv12.put("traducao", "The check, please?");
        cv12.put("categoria","alimentacao");
        cv12.put("favorito", "false");
        cv12.put("idiomaOriginal","portugues");
        cv12.put("idiomaTraducao","ingles");
        frases.add(cv12);

        ContentValues cv13 = new ContentValues();
        cv13.put("original", "Isto é empanado?");
        cv13.put("traducao", "Is this coat in bread?");
        cv13.put("categoria","alimentacao");
        cv13.put("favorito", "false");
        cv13.put("idiomaOriginal","portugues");
        cv13.put("idiomaTraducao","ingles");
        frases.add(cv13);

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
        cv15.put("traducao", "I would like a pint");
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
        cv22.put("original", "Vocês aceitam cartão de crédito ou apenas dinheiro?");
        cv22.put("traducao", "Do you take credit card or just cash?");
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




        return frases;
    }

}
