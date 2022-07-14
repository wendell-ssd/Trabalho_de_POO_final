/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import fachada.Fachada;
import java.util.ArrayList;
import entidades.*;
/**
 *
 * @author Wendell
 */
public class InicializandoDados {
        public static void inicializar(Fachada fachada) {
                try {
                        fachada.cadastrarCarro(new Carro("fiat", "HXS8124", "localiza", "fortaleza"));
                        fachada.cadastrarCarro(new Carro("toyota", "HUW4778", "localiza", "fortaleza"));
                        fachada.cadastrarCarro(new Carro("volkswagen", "HVG0436", "movida", "fortaleza"));
                        fachada.cadastrarCarro(new Carro("fiat", "KBM7795", "localiza", "goiania"));
                        fachada.cadastrarCarro(new Carro("toyota", "KBJ3627", "localiza", "goiania"));
                        fachada.cadastrarCarro(new Carro("volkswagen", "KCS5431", "movida", "goiania"));
                        fachada.cadastrarCarro(new Carro("fiat", "MUF3702", "localiza", "maceio"));
                        fachada.cadastrarCarro(new Carro("toyota", "MUG0478", "localiza", "maceio"));
                        fachada.cadastrarCarro(new Carro("volkswagen", "MVB0553", "movida", "maceio"));
                        fachada.cadastrarCarro(new Carro("fiat", "JNZ4122", "localiza", "salvador"));
                        fachada.cadastrarCarro(new Carro("toyota", "JOS2140", "localiza", "salvador"));
                        fachada.cadastrarCarro(new Carro("volkswagen", "JNU6042", "movida", "salvador"));
                        fachada.cadastrarCarro(new Carro("fiat", "LVW1491", "localiza", "teresina"));
                        fachada.cadastrarCarro(new Carro("toyota", "LVZ0176", "localiza", "teresina"));
                        fachada.cadastrarCarro(new Carro("volkswagen", "LVU9364", "movida", "teresina"));

                        fachada.cadastrarViajante(new Viajante("Eliabe", new Data(17, 02, 1998), "11111111",
                                        new Senha("senha1")));
                        fachada.cadastrarViajante(new Viajante("Gabriel", new Data(01, 01, 2010), "22222222",
                                        new Senha("senha2")));
                        fachada.cadastrarViajante(
                                        new Viajante("Weatherly", new Data(01, 01, 2000), "33333333",
                                                        new Senha("senha3")));
                        fachada.cadastrarViajante(new Viajante("Wendell", new Data(01, 01, 2001), "44444444",
                                        new Senha("senha4")));
                        fachada.cadastrarViajante(
                                        new Viajante("Igor", new Data(01, 01, 2002), "55555555", new Senha("senha5")));

                        ArrayList<Quarto> quartos1 = new ArrayList<Quarto>();
                        quartos1.add(new Quarto("eSuites", 3));
                        quartos1.add(new Quarto("eSuites", 4));
                        quartos1.add(new Quarto("eSuites", 2));
                        quartos1.add(new Quarto("eSuites", 3));
                        quartos1.add(new Quarto("eSuites", 5));
                        fachada.cadastrarHotel(new Hotel("eSuites", "123456789", quartos1, 4, "fortaleza"));

                        ArrayList<Quarto> quartos2 = new ArrayList<Quarto>();
                        quartos2.add(new Quarto("Montreual", 3));
                        quartos2.add(new Quarto("Montreual", 4));
                        quartos2.add(new Quarto("Montreual", 2));
                        quartos2.add(new Quarto("Montreual", 3));
                        quartos2.add(new Quarto("Montreual", 5));
                        fachada.cadastrarHotel(new Hotel("Montreual", "3743802802", quartos2, 5, "goiania"));

                        ArrayList<Quarto> quartos3 = new ArrayList<Quarto>();
                        quartos3.add(new Quarto("Transamerica", 3));
                        quartos3.add(new Quarto("Transamerica", 4));
                        quartos3.add(new Quarto("Transamerica", 2));
                        quartos3.add(new Quarto("Transamerica", 3));
                        quartos3.add(new Quarto("Transamerica", 5));
                        fachada.cadastrarHotel(new Hotel("Transamerica", "08650688065", quartos3, 2, "maceio"));

                        ArrayList<Quarto> quartos4 = new ArrayList<Quarto>();
                        quartos4.add(new Quarto("Notovel", 3));
                        quartos4.add(new Quarto("Notovel", 4));
                        quartos4.add(new Quarto("Notovel", 2));
                        quartos4.add(new Quarto("Notovel", 3));
                        quartos4.add(new Quarto("Notovel", 5));
                        fachada.cadastrarHotel(new Hotel("Notovel", "1312600988", quartos4, 5, "salvador"));

                        ArrayList<Quarto> quartos5 = new ArrayList<Quarto>();
                        quartos5.add(new Quarto("Esplanada", 3));
                        quartos5.add(new Quarto("Esplanada", 5));
                        quartos5.add(new Quarto("Esplanada", 2));
                        quartos5.add(new Quarto("Esplanada", 3));
                        quartos5.add(new Quarto("Esplanada", 5));
                        fachada.cadastrarHotel(new Hotel("Esplanada", "123456789", quartos5, 4, "teresina"));

                        fachada
                                        .cadastrarViajante(
                                                        new Viajante("Eliabe", new Data(01, 01, 2000), "1111111111111",
                                                                        new Senha("lindo2022")));
                        fachada.cadastrarViajante(
                                        new Viajante("Gabriel", new Data(01, 01, 2000), "22222222222",
                                                        new Senha("lindo2021")));
                        fachada
                                        .cadastrarViajante(
                                                        new Viajante("Weatherly", new Data(01, 01, 2000), "33333333333",
                                                                        new Senha("lindo2020")));
                        fachada.cadastrarViajante(
                                        new Viajante("Wendell", new Data(01, 01, 2000), "4444444444",
                                                        new Senha("lindo2019")));
                        fachada.cadastrarViajante(
                                        new Viajante("Igor", new Data(01, 01, 2000), "555555555555",
                                                        new Senha("lindo2018")));

                        fachada.cadastrarViagem(
                                        new Viagem(
                                                        fachada.pesquisarViajante("1111111111111"),
                                                        "fortaleza",
                                                        "goiania",
                                                        new Data(8, 07, 2022),
                                                        new Data(9, 07, 2002),
                                                        "economica",
                                                        2,
                                                        123,
                                                        "azul",
                                                        fachada.checkIn(
                                                                        "eSuites",
                                                                        fachada.pesquisarViajante("1111111111111"),
                                                                        new Data(8, 07, 2022),
                                                                        new Data(10, 07, 2022),
                                                                        1),
                                                        fachada.alugarCarro(
                                                                        "KBM7795",
                                                                        new Data(8, 07, 2022),
                                                                        new Data(9, 07, 2022),
                                                                        1)));

                        fachada.cadastrarViagem(new Viagem(
                                        fachada.pesquisarViajante("1111111111111"),
                                        "fortaleza",
                                        "goiania",
                                        new Data(8, 07, 2022),
                                        new Data(9, 07, 2002),
                                        "economica",
                                        2,
                                        123,
                                        "azul",
                                        fachada.checkIn(
                                                        "eSuites",
                                                        fachada.pesquisarViajante("1111111111111"),
                                                        new Data(8, 07, 2022),
                                                        new Data(10, 07, 2022),
                                                        3),
                                        fachada.alugarCarro(
                                                        "KCS5431",
                                                        new Data(8, 07, 2022),
                                                        new Data(9, 07, 2022),
                                                        2)));

                        fachada.cadastrarViagem(new Viagem(
                                        fachada.pesquisarViajante("22222222222"),
                                        "Salvador",
                                        "Teresina",
                                        new Data(8, 07, 2022),
                                        new Data(9, 07, 2002),
                                        "economica",
                                        1,
                                        342,
                                        "azul",
                                        fachada.checkIn(
                                                        "Montreual",
                                                        fachada.pesquisarViajante("22222222222"),
                                                        new Data(8, 07, 2022),
                                                        new Data(10, 07, 2022),
                                                        2),
                                        fachada.alugarCarro(
                                                        "LVW1491",
                                                        new Data(8, 07, 2022),
                                                        new Data(10, 07, 2022),
                                                        4)));

                        fachada.cadastrarViagem(new Viagem(
                                        fachada.pesquisarViajante("33333333333"),
                                        "fortaleza",
                                        "Salvador",
                                        new Data(8, 07, 2022),
                                        new Data(9, 07, 2002),
                                        "economica",
                                        3,
                                        987,
                                        "azul",
                                        fachada.checkIn(
                                                        "Esplanada",
                                                        fachada.pesquisarViajante("33333333333"),
                                                        new Data(8, 07, 2022),
                                                        new Data(10, 07, 2022),
                                                        5),
                                        fachada.alugarCarro(
                                                        "JNZ4122",
                                                        new Data(8, 07, 2022),
                                                        new Data(11, 07, 2022),
                                                        3)));

                        fachada.cadastrarViagem(new Viagem(
                                        fachada.pesquisarViajante("4444444444"),
                                        "goiania",
                                        "fortaleza",
                                        new Data(8, 07, 2022),
                                        new Data(9, 07, 2002),
                                        "economica",
                                        1,
                                        124,
                                        "azul",
                                        fachada.checkIn(
                                                        "eSuites",
                                                        fachada.pesquisarViajante("33333333333"),
                                                        new Data(8, 07, 2022),
                                                        new Data(10, 07, 2022),
                                                        2),
                                        fachada.alugarCarro(
                                                        "HXS8124",
                                                        new Data(8, 07, 2022),
                                                        new Data(12, 07, 2022),
                                                        3)));

                        fachada.cadastrarViagem(new Viagem(
                                        fachada.pesquisarViajante("555555555555"),
                                        "Teresina",
                                        "goiania",
                                        new Data(8, 07, 2022),
                                        new Data(9, 07, 2002),
                                        "economica",
                                        0,
                                        234,
                                        "azul",
                                        fachada.checkIn(
                                                        "Esplanada",
                                                        fachada.pesquisarViajante("33333333333"),
                                                        new Data(8, 07, 2022),
                                                        new Data(10, 07, 2022),
                                                        3),
                                        fachada.alugarCarro(
                                                        "LVU9364",
                                                        new Data(8, 07, 2022),
                                                        new Data(13, 07, 2022),
                                                        4)));
                } catch (Exception excecao) {
                        System.out.println("Problema aos subir os dados \n" + excecao);
                }

                System.out.println(fachada.mostrarTodosAsViagens());
                System.out.println(fachada.mostrarTodosHoteis());
                System.out.println(fachada.mostrarTodosCarros());
                System.out.println(fachada.mostrarTodosViajantes());

                for (Hotel hotel : fachada.listarHoteis()) {
                        System.out.println(fachada.mostrarTodosQuartos(hotel));
                }
        }

}
