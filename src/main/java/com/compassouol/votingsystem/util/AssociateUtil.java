package com.compassouol.votingsystem.util;

import com.compassouol.votingsystem.model.dto.AssociateDTO;

import java.util.InputMismatchException;

public class AssociateUtil {

    public static Boolean checkDocumentValid(AssociateDTO associateDTO) {
        if (associateDTO.getDocument().equals("00000000000") ||
                associateDTO.getDocument().equals("11111111111") ||
                associateDTO.getDocument().equals("22222222222") || associateDTO.getDocument().equals("33333333333") ||
                associateDTO.getDocument().equals("44444444444") || associateDTO.getDocument().equals("55555555555") ||
                associateDTO.getDocument().equals("66666666666") || associateDTO.getDocument().equals("77777777777") ||
                associateDTO.getDocument().equals("88888888888") || associateDTO.getDocument().equals("99999999999") ||
                (associateDTO.getDocument().length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(associateDTO.getDocument().charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(associateDTO.getDocument().charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == associateDTO.getDocument().charAt(9)) && (dig11 == associateDTO.getDocument().charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException error) {
            return(false);
        }
    }

}
