package src.dao;

import android.content.ContentValues;

import java.util.ArrayList;

/**
 * Created by Windows on 24/10/2017.
 */

public class FirstLoad {

    public ArrayList<ContentValues> frases = new ArrayList<>();

    public ArrayList<ContentValues> firstInsert() {
        ContentValues cv1 = new ContentValues();
        cv1.put("original", "Quanto eu devo pagar por excesso de peso?");
        cv1.put("traducao", "How much do I have to pay for excess weight?");
        cv1.put("categoria","viagens");
        cv1.put("favorito", "false");
        cv1.put("idiomaOriginal","portugues");
        cv1.put("idiomaTraducao","ingles");
        frases.add(cv1);

        ContentValues cv2 = new ContentValues();
        cv2.put("original", "Você tem algum quarto livre?");
        cv2.put("traducao", "Do you have any room available?");
        cv2.put("categoria","viagens");
        cv2.put("favorito", "false");
        cv2.put("idiomaOriginal","portugues");
        cv2.put("idiomaTraducao","ingles");
        frases.add(cv2);

        ContentValues cv3 = new ContentValues();
        cv3.put("original", "Onde posso encontrar um ponto de taxi?");
        cv3.put("traducao", "Where can I find a cab stand?");
        cv3.put("categoria","comum");
        cv3.put("favorito", "false");
        cv3.put("idiomaOriginal","portugues");
        cv3.put("idiomaTraducao","ingles");
        frases.add(cv3);

        ContentValues cv4 = new ContentValues();
        cv4.put("original", "Eu gostaria de fazer meu pedido, por favor");
        cv4.put("traducao", "I would like to order, please");
        cv4.put("categoria","alimentacao");
        cv4.put("favorito", "false");
        cv4.put("idiomaOriginal","portugues");
        cv4.put("idiomaTraducao","ingles");
        frases.add(cv4);

        ContentValues cv5 = new ContentValues();
        cv5.put("original", "A conta, por favor");
        cv5.put("traducao", "The check, please");
        cv5.put("categoria","alimentacao");
        cv5.put("favorito", "false");
        cv5.put("idiomaOriginal","portugues");
        cv5.put("idiomaTraducao","ingles");
        frases.add(cv5);

        ContentValues cv6 = new ContentValues();
        cv6.put("original", "Vocês aceitam cartão de crédito ou apenas dinheiro?");
        cv6.put("traducao", "Do you take credit card or just cash?");
        cv6.put("categoria","comum");
        cv6.put("favorito", "false");
        cv6.put("idiomaOriginal","portugues");
        cv6.put("idiomaTraducao","ingles");
        frases.add(cv6);

        ContentValues cv7 = new ContentValues();
        cv7.put("original", "Qual a senha para conectar na wifi?");
        cv7.put("traducao", "What's the password to connect the wifi?");
        cv7.put("categoria","comum");
        cv7.put("favorito", "false");
        cv7.put("idiomaOriginal","portugues");
        cv7.put("idiomaTraducao","ingles");
        frases.add(cv7);

        ContentValues cv8 = new ContentValues();
        cv8.put("original", "Você tem troco?");
        cv8.put("traducao", "Do you have change?");
        cv8.put("categoria","comum");
        cv8.put("favorito", "false");
        cv8.put("idiomaOriginal","portugues");
        cv8.put("idiomaTraducao","ingles");
        frases.add(cv8);

        ContentValues cv9 = new ContentValues();
        cv9.put("original", "Este vôo é direto?");
        cv9.put("traducao", "Is this flight non-stop?");
        cv9.put("categoria","viagens");
        cv9.put("favorito", "false");
        cv9.put("idiomaOriginal","portugues");
        cv9.put("idiomaTraducao","ingles");
        frases.add(cv9);

        ContentValues cv10 = new ContentValues();
        cv10.put("original", "Quanto custa isso?");
        cv10.put("traducao", "How much this costs?");
        cv10.put("categoria","comum");
        cv10.put("favorito", "false");
        cv10.put("idiomaOriginal","portugues");
        cv10.put("idiomaTraducao","ingles");
        frases.add(cv10);

        ContentValues cv11 = new ContentValues();
        cv11.put("original", "Eu acho que estou com conjuntivite");
        cv11.put("traducao", "I think I have pink eye");
        cv11.put("categoria","saude");
        cv11.put("favorito", "false");
        cv11.put("idiomaOriginal","portugues");
        cv11.put("idiomaTraducao","ingles");
        frases.add(cv11);

        ContentValues cv12 = new ContentValues();
        cv12.put("original", "Quanto é por dia?");
        cv12.put("traducao", "How much per day?");
        cv12.put("categoria","viagens");
        cv12.put("favorito", "false");
        cv12.put("idiomaOriginal","portugues");
        cv12.put("idiomaTraducao","ingles");
        frases.add(cv12);

        ContentValues cv13 = new ContentValues();
        cv13.put("original", "Eu gostaria de fazer o check in, por favor?");
        cv13.put("traducao", "I would like to check in, please?");
        cv13.put("categoria","viagens");
        cv13.put("favorito", "false");
        cv13.put("idiomaOriginal","portugues");
        cv13.put("idiomaTraducao","ingles");
        frases.add(cv13);


        ContentValues cv14 = new ContentValues();
        cv14.put("original", "Eu gostaria de fazer o check out, por favor?");
        cv14.put("traducao", "I would like to check out, please?");
        cv14.put("categoria","viagens");
        cv14.put("favorito", "false");
        cv14.put("idiomaOriginal","portugues");
        cv14.put("idiomaTraducao","ingles");
        frases.add(cv14);

        ContentValues cv15 = new ContentValues();
        cv15.put("original", "Quanto é pela corrida?");
        cv15.put("traducao", "How much for the ride?");
        cv15.put("categoria","comum");
        cv15.put("favorito", "false");
        cv15.put("idiomaOriginal","portugues");
        cv15.put("idiomaTraducao","ingles");
        frases.add(cv15);





        return frases;
    }

}
