
public class BuscaFrete {

    static class txFretes {

        static double fMotComSeg = 1.50;
        static double fMotSemSeg = .9;
        static double txUrgMot = 10;
        static double txUrgUtil = 30;
        static double txPerecUtil = 20;
        static double fUtiliComRefriComSeg = 5;
        static double fUtiliComRefriSemSeg = 4.5;
        static double fUtiliSemRefriComSeg = 3.8;
        static double fUtiliSemRefriSemSeg = 3.2;

    }

    public static double calcMaisBarato(long origem, long destino, int peso, boolean cargaPerecivel, boolean urgente, boolean temSeguro) {

        long distancia = destino - origem;
        double valor = 0;

        if(distancia <= 50) { // menos de 50km vai de moto...
            if(peso <= 30) { // claro se não for muito pesado....não queremos ver o motoboy caindo
                if(!cargaPerecivel) { // ah tem que ver se é perecivel...tipo não tem moto com bau refrigerado
                    if(urgente) { // tem um esquema se for urgente, a gente cobra uma taxa...os caras inventaram essa porra aí
                        if(temSeguro) { // ah tem o lance do seguro...tem gente que manda joias e tals
                            return (valor * txFretes.fMotComSeg) + txFretes.txUrgMot;
                        } else {
                            return (valor * txFretes.fMotSemSeg) + txFretes.txUrgMot;
                        }
                    } else {
                        if(temSeguro) {
                            return (valor * txFretes.fMotComSeg);
                        } else {
                            return (valor * txFretes.fMotSemSeg);
                        }
                    }
                } else { // dai quando for perecível, tem que cobrar mais uma taxa do perecivel..
                    if(urgente) {
                        if(temSeguro) {
                            return (valor * txFretes.fUtiliComRefriComSeg) + txFretes.txUrgUtil + txFretes.txPerecUtil;
                        } else {
                            return (valor * txFretes.fUtiliSemRefriComSeg) + txFretes.txUrgUtil + txFretes.txPerecUtil;
                        }
                    } else {
                        if(temSeguro) {
                            return (valor * txFretes.fUtiliComRefriComSeg) + txFretes.txPerecUtil;
                        } else {
                            return (valor * txFretes.fUtiliSemRefriComSeg) + txFretes.txPerecUtil;
                        }
                    }
                }
            } else {
                if(peso <= 700) { //até 200km a gente manda de carro utilitario
                    if(!cargaPerecivel) { // ah tem que ver se é perecivel...tipo não tem moto com bau refrigerado
                        if(urgente) { // tem um esquema se for urgente, a gente cobra uma taxa...os caras inventaram essa porra aí
                            if(temSeguro) { // ah tem o lance do seguro...tem gente que manda joias e tals
                                return (valor * txFretes.fUtiliSemRefriComSeg) + txFretes.txUrgUtil;
                            } else {
                                return (valor * txFretes.fUtiliSemRefriSemSeg) + txFretes.txUrgUtil;
                            }
                        } else {
                            if(temSeguro) { // ah tem o lance do seguro...tem gente que manda joias e tals
                                return (valor * txFretes.fUtiliSemRefriComSeg) ;
                            } else {
                                return (valor * txFretes.fUtiliSemRefriSemSeg) ;
                            }
                        }
                    } else { // dai quando for perecível, tem que cobrar mais uma taxa do perecivel..
                        if(urgente) {
                            if(temSeguro) {
                                return (valor * txFretes.fUtiliComRefriComSeg) + txFretes.txPerecUtil + txFretes.txUrgUtil ;
                            } else {
                                return (valor * txFretes.fUtiliComRefriSemSeg) + txFretes.txPerecUtil + txFretes.txUrgUtil;
                            }
                        } else {
                            if(temSeguro) {
                                return (valor * txFretes.fUtiliSemRefriComSeg) + txFretes.txPerecUtil ;
                            } else {
                                return (valor * txFretes.fUtiliComRefriSemSeg) + txFretes.txPerecUtil ;
                            }
                        }
                    }
                }
            }
        } else if (distancia > 50 && distancia <= 300) {

            if(peso <= 700) { //até 200km a gente manda de carro utilitario
                if(!cargaPerecivel) { // ah tem que ver se é perecivel...tipo não tem moto com bau refrigerado
                    if(urgente) { // tem um esquema se for urgente, a gente cobra uma taxa...os caras inventaram essa porra aí
                        if(temSeguro) { // ah tem o lance do seguro...tem gente que manda joias e tals
                            return (valor * txFretes.fUtiliSemRefriComSeg) + txFretes.txUrgUtil;
                        } else {
                            return (valor * txFretes.fUtiliSemRefriSemSeg) + txFretes.txUrgUtil;
                        }
                    } else {
                        if(temSeguro) { // ah tem o lance do seguro...tem gente que manda joias e tals
                            return (valor * txFretes.fUtiliSemRefriComSeg) ;
                        } else {
                            return (valor * txFretes.fUtiliSemRefriSemSeg) ;
                        }
                    }
                } else { // dai quando for perecível, tem que cobrar mais uma taxa do perecivel..
                    if(urgente) {
                        if(temSeguro) {
                            return (valor * txFretes.fUtiliComRefriComSeg) + txFretes.txPerecUtil + txFretes.txUrgUtil ;
                        } else {
                            return (valor * txFretes.fUtiliComRefriSemSeg) + txFretes.txPerecUtil + txFretes.txUrgUtil;
                        }
                    } else {
                        if(temSeguro) {
                            return (valor * txFretes.fUtiliSemRefriComSeg) + txFretes.txPerecUtil ;
                        } else {
                            return (valor * txFretes.fUtiliComRefriSemSeg) + txFretes.txPerecUtil ;
                        }
                    }
                }
            }
        }

        // quando a distancia for maior que 300, a gente nega o pedido de frete...por enquanto
        return -1;

    }

}
