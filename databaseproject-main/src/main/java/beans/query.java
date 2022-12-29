package beans;

public class query {
	
	public static String getQuery = "SELECT * " + "FROM "
			+ "(SELECT "
			+ "`id`, `SCP`, `Title`, `rating`, `Classification`, `Type`, `Related_GOI_s`, `Location_Notes`, `Author`, "
			+ "`Leaked_info`, `Humanoid_or_Structure`, `Animal_Computer_or_Extradimensional`, `Autonomous_or_Cognitohazard`, "
			+ " `Artifact_Location_or_Sentient`, `Summary`, `Gender`, `None`, `Ethnicity_Origins`  FROM `bearbase` "
			+ "UNION ALL "
			+ "SELECT `id`, `SCP`, `Title`, `rating`, `Classification`, `Type`, `Related_GOI_s`, `Location_Notes`, `Author`, "
			+ " `Leaked_info`, `Humanoid_or_Structure`, `Animal_Computer_or_Extradimensional`, `Autonomous_or_Cognitohazard`, "
			+ " `Artifact_Location_or_Sentient`, `Summary`, `Gender`, `None`, `Ethnicity_Origins` FROM `ikea_names` "
			+ "UNION ALL "
			+ "SELECT `id`, `SCP`, `Title`, `rating`, `Classification`, `Type`, `Related_GOI_s`, `Location_Notes`, `Author`, "
			+ "`Leaked_info`, `Humanoid_or_Structure`, `Animal_Computer_or_Extradimensional`, `Autonomous_or_Cognitohazard`, "
			+ "`Artifact_Location_or_Sentient`, `Summary`, `Gender`, `None`, `Ethnicity_Origins` FROM `masterscplist`) AS"
			+ "			tmpTable " + "			WHERE `SCP` LIKE ? " + "			OR `Title`  LIKE ? "
			+ "			OR `rating`  LIKE ? " + "			OR `Classification`  LIKE ? "
			+ "			OR `Type`  LIKE ? " + "			OR `Related_GOI_s`  LIKE ? "
			+ "			OR `Location_Notes`  LIKE ? " + "			OR `Author`  LIKE ? "
			+ "			OR `Leaked_info`  LIKE ? " + "			OR `Humanoid_or_Structure`  LIKE ? "
			+ "			OR `Animal_Computer_or_Extradimensional`  LIKE ? "
			+ "			OR `Autonomous_or_Cognitohazard`  LIKE ? "
			+ "			OR `Artifact_Location_or_Sentient`  LIKE ? " + "			OR `Summary`  LIKE ? "
			+ "			OR `Gender`  LIKE ? " + "			OR `None`  LIKE ? "
			+ "			OR `Ethnicity_Origins`  LIKE ? ";

	public static String getQuery() {
		return getQuery;
	}
}
