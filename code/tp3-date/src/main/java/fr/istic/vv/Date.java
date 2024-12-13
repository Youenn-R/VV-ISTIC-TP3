package fr.istic.vv;

class Date implements Comparable<Date> {
    /**
     * Le jour de la date
     */
    private final int day;

    /**
     * Le mois de la date pouvant aller de 1 à 12
     */
    private final int month;


    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * L'année de la date
     */
    private final int year;

    public Date(int day, int month, int year) throws NotADateException {
        // S'il s'agit d'une date valide alors on la créait
        if (isValidDate(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        // Sinon on lève une erreur
        else {
            throw new NotADateException("Les valeurs données ne forment pas une date.");
        }
    }

    /**
     * Vérifie si l'on obtient une date valide à partir de ces valeurs
     * @param day Le jour
     * @param month Le mois
     * @param year L'année
     * @return Si la date produite à partir de ces valeurs est possible
     */
    public static boolean isValidDate(int day, int month, int year) {
        // On vérifie dans un premier temps si les valeurs du jour et du mois ne sont pas nulles
        // et si le mois ne dépasse pas 12.
        if (day > 0 && month > 0 && month < 13){
            // On vérifie ensuite que le jour ne dépasse pas le compte de jours du mois.
            return day <= getNumberOfDaysByMonth(month, year);
        }
        return false;
    }

    /**
     * Vérifie s'il s'agit d'une année bissextile
     * @param year Année que l'on souhaite évaluer
     * @return S'il s'agit d'une année bissextile.
     */
    public static boolean isLeapYear(int year) {
        // Si c'est divisible par 400, alors l'année est forcément bissextile
        if (year % 400 != 0){
            // Sinon, elle doit être divisible par 4 mais pas par 100
            return year % 4 == 0 && year % 100 != 0;
        }
        return true;
    }

    /**
     * Retourne le lendemain de notre date
     * @return Une nouvelle date correspondant au lendemain.
     * @throws NotADateException Ne devrait pas être jetée.
     */
    public Date nextDate() throws NotADateException {
        int nextDay = this.day % getNumberOfDaysByMonth(this.month, this.year) +1;
        int nextMonth = this.month;
        int nextYear = this.year;
        if (nextDay == 1){
            nextMonth = month % 12 + 1;
            if (nextMonth == 1){
                nextYear = nextYear + 1;
            }
        }
        return new Date(nextDay, nextMonth, nextYear);
    }

    /**
     * Retourne la veille de notre date
     * @return Une nouvelle date correspondant à la veille.
     * @throws NotADateException Ne devrait pas être jetée
     */
    public Date previousDate() throws NotADateException {
        int previousDay = this.day - 1;
        int previousMonth = this.month;
        int previousYear = this.year;
        if (previousDay <= 0){
            previousMonth = month - 1;
            if (previousMonth <= 0){
                previousYear = previousYear - 1;
                previousMonth = 12;
            }
            // On ne peut se permettre de calculer la date qu'à la fin
            // des réajustements pour s'assurer d'avoir un mois et une année correcte.
            previousDay = getNumberOfDaysByMonth(previousMonth, previousYear);
        }
        return new Date(previousDay, previousMonth, previousYear);
    }

    /**
     * Permet d'obtenir le nombre de jours dans un mois en fonction
     * du mois et de l'année (pour prendre en compte les années bissextiles.
     * @param month Le mois
     * @param year L'année
     * @return Le nombre de jours dans ce mois.
     */
    public static int getNumberOfDaysByMonth(int month, int year){
        if (month == 2 ){
            return isLeapYear(year) ? 29 : 28;
        }
        boolean pair = month%2 == 0;
        if (month <= 7){
           return pair ? 30 : 31;
        }
        else {
            return pair ? 31 : 30;
        }
    }

    /**
     * Permet de comparer deux dates
     * @param other the object to be compared.
     * @return Positif si la première date est plus grande, négative si elle est petite et 0 si ce sont les mêmes.
     */
    public int compareTo(Date other) {
        if (this.year == other.year){
            if (this.month == other.month){
                return this.day - other.day;
            }
            return this.month - other.month;
        }
        return this.year - other.year;
    }

}