package rullofx.board.model;

/**
 * Données du plateau de jeu
 */
public class BoardData {
    private int columnCount;
    private int rowCount;
    private Cell[][] cells;
    private Sum[] columnSums;
    private Sum[] rowSums;
    
    /**
     * Constructeur
     * @param rowCount nombre de lignes
     * @param columnCount nombre de colonnes
     */
    public BoardData(int rowCount, int columnCount) {
    	this.columnCount= columnCount;
    	this.rowCount= rowCount;  	
    	this.cells= new Cell[rowCount][columnCount];
    	this.columnSums=new Sum[columnCount];    
    	this.rowSums= new Sum[rowCount];
    }
    
    /**
     * Retourne le nombre de colonnes du plateau de jeu
     * @return nombre de colonnes
     */
    public int getColumnCount() {
        return columnCount;
    }

    /**
     * Retourne le nombre de lignes du plateau de jeu
     * @return nombre de lignes
     */
    public int getRowCount() {
        return rowCount;
    }

    /**
     * Retourne une cellule du plateau de jeu
     * @param row ligne de la cellule
     * @param column colonne de la cellule
     * @return cellule
     */
    public Cell getCell(int row, int column) {
        return cells[row][column];
    }
    
    /**
     * Initialise une cellule du plateau de jeu.
     * @param row ligne de la cellule
     * @param column colonne de la cellule
     * @param value valeur de la cellule
     */
    public void initCell(int row, int column, int value) {
        this.cells[row][column]=new Cell(value);
    }
    
    /**
     * Retourne la somme d'une colonne du plateau de jeu
     * @param column colonne de la somme
     * @return somme
     */
    public Sum getColumnSum(int column) {
        return columnSums[column];
    }
    
    /**
     * Initialise une somme de colonne du plateau de jeu
     * @param column colonne de la somme
     * @param target somme à atteindre pour la colonne
     */
    public void initColumnSum(int column, int target) {
        // à compléter
    }

    /**
     * Retourne la somme d'une ligne du plateau de jeu
     * @param row ligne de la somme
     * @return somme
     */
    public Sum getRowSum(int row) {
        return rowSums[row];
    }

    /**
     * Initialise une somme de ligne du plateau de jeu
     * @param row ligne de la somme
     * @param target somme à atteindre pour la ligne
     */
    public void initRowSum(int row, int target) {
        // à compléter
    }
}