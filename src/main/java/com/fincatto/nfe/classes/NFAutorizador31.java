package com.fincatto.nfe.classes;

import java.util.Arrays;

public enum NFAutorizador31 {
    SVRS {

        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.AC, NFUnidadeFederativa.AL, NFUnidadeFederativa.AM, NFUnidadeFederativa.AP, NFUnidadeFederativa.DF, NFUnidadeFederativa.MS, NFUnidadeFederativa.PB, NFUnidadeFederativa.RJ, NFUnidadeFederativa.RO, NFUnidadeFederativa.RR, NFUnidadeFederativa.SC, NFUnidadeFederativa.SE, NFUnidadeFederativa.TO };
        }
    },
    RS {
        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx" : "https://nfe.sefaz.rs.gov.br/ws/NfeAutorizacao/NFeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx" : "https://nfe.sefazvirtual.rs.gov.br/ws/NfeRetAutorizacao/NFeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx" : "https://nfe.sefaz.rs.gov.br/ws/NfeConsulta/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://homologacao.nfe.sefaz.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx" : "https://nfe.sefaz.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.RS };
        }
    },
    SCAN {

        @Override
        public String getNfeAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeAutorizacao/NfeAutorizacao.asmx" : "https://www.scan.fazenda.gov.br/NfeAutorizacao/NfeAutorizacao.asmx";
        }

        @Override
        public String getNfeRetAutorizacao(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeRetAutorizacao/NfeRetAutorizacao.asmx" : "https://www.scan.fazenda.gov.br/NfeRetAutorizacao/NfeRetAutorizacao.asmx";
        }

        @Override
        public String getNfeConsultaProtocolo(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeConsulta2/NfeConsulta2.asmx" : "https://www.scan.fazenda.gov.br/NfeConsulta2/NfeConsulta2.asmx";
        }

        @Override
        public String getNfeStatusServico(final NFAmbiente ambiente) {
            return NFAmbiente.HOMOLOGACAO.equals(ambiente) ? "https://hom.nfe.fazenda.gov.br/SCAN/NfeStatusServico2/NfeStatusServico2.asmx" : "https://www.scan.fazenda.gov.br/NfeStatusServico2/NfeStatusServico2.asmx";
        }

        @Override
        public NFUnidadeFederativa[] getUFs() {
            return new NFUnidadeFederativa[] { NFUnidadeFederativa.SC };
        }

    };

    public abstract String getNfeAutorizacao(NFAmbiente ambiente);

    public abstract String getNfeRetAutorizacao(NFAmbiente ambiente);

    public abstract String getNfeConsultaProtocolo(NFAmbiente ambiente);

    public abstract String getNfeStatusServico(final NFAmbiente ambiente);

    public abstract NFUnidadeFederativa[] getUFs();

    public static NFAutorizador31 valueOfCodigoUF(final NFUnidadeFederativa uf) {
        if (uf != null) {
            for (final NFAutorizador31 aut : NFAutorizador31.values()) {
                if (Arrays.asList(aut.getUFs()).contains(uf)) {
                    return aut;
                }
            }
        }
        return null;
    }

    public static NFAutorizador31 valueOfChaveAcesso(final String chaveAcesso) {
        final NFChaveInterpretador chaveInterpretador = new NFChaveInterpretador(chaveAcesso);
        // @TODO SCAN será desativado em 30/09/2014
        if (chaveInterpretador.isEmitidaContingenciaSCAN()) {
            // return NFAutorizador.SCAN;
            return null;
        }
        return NFAutorizador31.valueOfCodigoUF(chaveInterpretador.getUnidadeFederativa());
    }

}