package transferUtil;

/**
 * The Operation interface defines constants representing various system operations.
 * 
 * <p>
 * These constants can be used to identify different types of operations when communicating between
 * different parts of the system.
 * </p>
 * 
 * @see Serializable
 * @author Irena Randjelovic
 *
 */
public interface Operation {
	
	/**
     * Constant representing operation for performing login.
     */
	public static final int LOGIN = 0;

	/**
	 * Constant representing operation for retrieving all administrators.
	 */
    public static final int GET_ALL_ADMINISTRATOR = 1;

    /**
	 * Constant representing operation for adding a new meeting (sastanak).
	 */
    public static final int ADD_SASTANAK = 2;
    
    /**
	 * Constant representing operation for deleting a meeting (sastanak).
	 */
    public static final int DELETE_SASTANAK = 3;
    
    /**
	 * Constant representing operation for updating a meeting (sastanak).
	 */
    public static final int UPDATE_SASTANAK = 4;
    
    /**
	 * Constant representing operation for retrieving all meetings (sastanak).
	 */
    public static final int GET_ALL_SASTANAK = 5;

    /**
	 * Constant representing operation for adding a new contact (sastanak).
	 */
    public static final int ADD_UGOVOR = 6;
    
    /**
	 * Constant representing operation for deleting a contact (sastanak).
	 */
    public static final int DELETE_UGOVOR = 7;
    
    /**
	 * Constant representing operation for updating a contact (sastanak).
	 */
    public static final int UPDATE_UGOVOR = 8;
    
    /**
	 * Constant representing operation for retrieving all contracts (ugovor).
	 */
    public static final int GET_ALL_UGOVOR = 9;

    /**
   	 * Constant representing operation for retrieving all contract items (stavkaUgovora).
   	 */
    public static final int GET_ALL_STAVKA_UGOVORA = 10;

    /**
   	 * Constant representing operation for retrieving all CR team memebers (clanCRTima).
   	 */
    public static final int GET_ALL_CLAN_CR_TIMA = 11;

    /**
   	 * Constant representing operation for retrieving all companies (kompanija).
   	 */
    public static final int GET_ALL_KOMPANIJA = 12;

    /**
   	 * Constant representing operation for retrieving all packages (paket).
   	 */
    public static final int GET_ALL_PAKET = 13;
}
