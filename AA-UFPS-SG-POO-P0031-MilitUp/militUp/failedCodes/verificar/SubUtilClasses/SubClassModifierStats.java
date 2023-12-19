package com.MilitUp.SubUtilClasses;

import com.MilitUp.PrincipalClasses.*;

public class SubClassModifierStats {
    private int modifiedVida;
    private int modifiedRango;
    private int modifiedMoral;
    private int modifiedArma;

    public SubClassModifierStats(SubClassReceiveStats stats) {
        modifyStats(stats);
    }

    private void modifyStats(SubClassReceiveStats stats) {
        // Obtener las estadísticas base del jugador
        Militar jugador = stats.getJugador();
        int baseVida = jugador.getVida();
        int baseRango = jugador.getRango();
        int baseMoral = jugador.getMoral();
        int baseArma = jugador.getArma();

        // Obtener los modificadores del país y el gobierno
        int countryStatPositive = stats.getCountry_StatPositive();
        int countryStatNegative = stats.getCountry_StatNegative();
        int governmentVidaPlus = stats.getGoverment_StatVidaPlus();
        int governmentRangoPlus = stats.getGoverment_StatRangoPlus();
        int governmentMoralPlus = stats.getGoverment_StatMoralPlus();
        int governmentArmaPlus = stats.getGoverment_StatArmaPlus();
        int governmentVidaLess = stats.getGoverment_StatVidaLess();
        int governmentRangoLess = stats.getGoverment_StatRangoLess();
        int governmentMoralLess = stats.getGoverment_StatMoralLess();
        int governmentArmaLess = stats.getGoverment_StatArmaLess();

        // Aplicar modificadores del país
        int modifiedVidaCountry = baseVida + (countryStatPositive - countryStatNegative)/* /2 */;
        int modifiedRangoCountry = baseRango + (countryStatPositive - countryStatNegative)/* /2 */;
        int modifiedMoralCountry = baseMoral + (countryStatPositive - countryStatNegative)/* /2 */;
        int modifiedArmaCountry = baseArma + (countryStatPositive - countryStatNegative)/* /2 */;

        // Aplicar modificadores del gobierno
        int modifiedVidaGovernment = (modifiedVidaCountry + governmentVidaPlus) - Math.abs(governmentVidaLess);
        int modifiedRangoGovernment = (modifiedRangoCountry + governmentRangoPlus) - Math.abs(governmentRangoLess);
        int modifiedMoralGovernment = (modifiedMoralCountry + governmentMoralPlus) - Math.abs(governmentMoralLess);
        int modifiedArmaGovernment = (modifiedArmaCountry + governmentArmaPlus) - Math.abs(governmentArmaLess);

        // Limitar las estadísticas modificadas al rango [0, 1000] para Vida, Rango y
        // Arma, [0, 100] para Moral
    }

    /*
     * public void validateLimits(int vidGov, int ranGov, int morGov, int armGov){
     * modifiedVida = Math.max(0, Math.min(1000, vidGov));
     * modifiedRango = Math.max(0, Math.min(1000, ranGov));
     * modifiedMoral = Math.max(0, Math.min(1000, morGov));
     * modifiedArma = Math.max(0, Math.min(1000, armGov));
     * }
     */

    public int getModifiedVida() {
        return modifiedVida;
    }

    public int getModifiedRango() {
        return modifiedRango;
    }

    public int getModifiedMoral() {
        return modifiedMoral;
    }

    public int getModifiedArma() {
        return modifiedArma;
    }
}
