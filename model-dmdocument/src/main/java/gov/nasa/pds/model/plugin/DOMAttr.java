package gov.nasa.pds.model.plugin; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class DOMAttr extends ISOClassOAIS11179 {
	String sort_identifier;							// lAttr.title + "_" + lAttr.steward + "_" + lAttr.className + "_" + lAttr.classSteward
//	String attrAnchorString;						// "attribute", lAttr.attrNameSpaceIdNC, lAttr.title, lAttr.classNameSpaceIdNC, lAttr.className
	String XMLSchemaName;							// Title or Class_Title
	String xPath;									// attribute xpath
//	String regAuthId;								// registration authority identifier
	String classSteward;							// steward for attribute's class
	String classNameSpaceIdNC;
	String submitter;								// submitter for attribute
	String parentClassTitle;						// class that this attribute is a member of
	DOMClass attrParentClass; 						// class instance that this attribute is a member of
													// *** deprecate *** moved to DOMProp
	String classConcept;							// for DEC
	String dataConcept;							    // for CD
	String classWord;								// for nomenclature rules
	String lddLocalIdentifier;						// LDD local identifier
	DOMAttr lddUserAttribute;						// the USER attribute used to initialize the LDD attribute

	String xmlBaseDataType;							// the XML base data type
	String protValType;								// value type from protege model
	String propType;								// Instance or Attribute
	String valueType;								// Master value type 
	String groupName;								// the choice group name
	String cardMin;
	String cardMax;
	int cardMinI;
	int cardMaxI;

	String minimum_characters;		// minimum number of characters
	String maximum_characters;		// maximum number of characters
	String minimum_value;			// minimum value 
	String maximum_value;			// maximum value 
	String format;					// a template for the structure of the presentation of the Value(s) e.g. YYYY-MM-DD for a date.
	String pattern;					// a regular expression
	String unit_of_measure_type;	//
	String default_unit_id;			//
	String unit_of_measure_precision;	//
		
//	String type;
	boolean isAttribute;			// true->attribute; false->association
	boolean isOwnedAttribute;		// true->attribute is owned by this class, as opposed to inherited
	boolean isPDS4;					// true->PDS4 keyword used in Protege
	boolean isEnumerated;
	boolean isUsedInClass;			// attribute is used in a class
	boolean isRestrictedInSubclass; // *** deprecate *** moved to DOMProp
	boolean isMeta;
	boolean hasAttributeOverride;
	boolean isNilable;
	boolean isChoice;				// Association or Instance attributes that require a class choice
	boolean isAny;					// Association or Instance attribute that allows a class any
	boolean isFromLDD;				// attribute came from an LDD
	boolean hasRetiredValue;		// at least one permissible value has been retired.
	boolean isCharDataType;			// the data type (aka valueType) of the attribute is character. XML Schema allows only max/min length for value.
	boolean isExposed;				// the attribute is to be exposed in XML Schema - i.e., defined using xs:Element
	
	DOMProp hasDOMPropInverse;		// the owning DOMProp of this Class 
	ArrayList <DOMProp> domPermValueArr;
	ArrayList <String> lValueTypeArr;
	
	ArrayList <String> valArr;
	ArrayList <PDSObjDefn> valClassArr;	// classes for for assoc (AttrDefn) valArr
	ArrayList <String> allowedUnitId;	// the unit ids allowed from the set of measurement units.
	HashMap <String, ArrayList<String>> genAttrMap; 
	ArrayList <PermValueDefn> permValueArr;
	ArrayList <PermValueExtDefn> permValueExtArr;
	TreeMap <String, String> valueDependencyMap;
	
	String dataIdentifier; 						// data identifier
	String deDataIdentifier;					// data element
	String decDataIdentifier;					// data element concept
	String ecdDataIdentifier;					// enumerated conceptual domain 
	String evdDataIdentifier;					// enumerated value domain
	String necdDataIdentifier;					// non enumerated conceptual domain 
	String nevdDataIdentifier;					// non enumerated value domain
	String pvDataIdentifier;					// permissible value
	String vmDataIdentifier;					// value meaning
	
	String desDataIdentifier;					// designation 
	String defDataIdentifier;					// definition
	String lsDataIdentifier;					// language section 
	String teDataIdentifier;					// terminological entry
	String prDataIdentifier;					// property data identifier (Attribute and Association)
	
	String administrationRecordValue;
	String versionIdentifierValue;
	String registeredByValue;
	String registrationAuthorityIdentifierValue;
	
	ArrayList <String> expressedByArr;
	ArrayList <String> representing1Arr;
	ArrayList <String> representedBy1Arr;
	ArrayList <String> representedBy2Arr;
	ArrayList <String> containedIn1Arr; 
	
	ArrayList <String> genClassArr;
	ArrayList <String> sysClassArr;	
	
	public DOMAttr () {
		sort_identifier = "TBD_sort_identifier";
//		attrAnchorString = "TBD_attrAnchorString";
		XMLSchemaName = "TBD_XMLSchemaName";
		xPath = "TBD_xPath";
		classSteward = "TBD_classSteward";
		classNameSpaceIdNC = "TBD_classNameSpaceId";
		submitter = "TBD_submitter";
		parentClassTitle = "TBD_parentClassTitle";
		attrParentClass = null;
		classConcept = "TBD_classConcept"; 
		dataConcept = "TBD_dataConcept"; 
		classWord = "TBD_classWord"; 
		lddLocalIdentifier = "TBD_lddLocalIdentifier";
		lddUserAttribute = null;

		xmlBaseDataType = "TBD_XML_Base_Data_Type";
		protValType = "TBD_Protege_Value_type";
		propType = "TBD_slot_type";
		valueType = "TBD_value_type";
		groupName = "TBD_groupName";
		cardMin = "TBD_cardMin";
		cardMax = "TBD_cardMax";
		cardMinI = -99999;
		cardMaxI = -99999;
		
		maximum_characters = "TBD_maximum_characters";
		minimum_characters = "TBD_minimum_characters";
		maximum_value = "TBD_maximum_value";
		minimum_value = "TBD_minimum_value";
		format = "TBD_format";
		pattern = "TBD_pattern";
		unit_of_measure_type = "TBD_unit_of_measure_type";
		default_unit_id = "TBD_default_unit_id";
		unit_of_measure_precision = "TBD_unit_of_measure_precision";
		
		isAttribute = true;
		isOwnedAttribute = false;
		isPDS4 = false;
		isEnumerated = false;
		isUsedInClass = false;
		isRestrictedInSubclass = false;
		isMeta = false;
		hasAttributeOverride = false;
		isNilable = false;
		isChoice = false;
		isAny = false;
		isFromLDD = false;
		hasRetiredValue = false;
		isCharDataType = true;
		isExposed = false;
		
		hasDOMPropInverse = null;
		domPermValueArr = new ArrayList <DOMProp> ();
		lValueTypeArr = new ArrayList <String> ();
		lValueTypeArr.add("Number");
		lValueTypeArr.add("ASCII_Integer");
		lValueTypeArr.add("ASCII_NonNegative_Integer");
//		lValueTypeArr.add("ASCII_Numeric_Base16");
//		lValueTypeArr.add("ASCII_Numeric_Base2"); // bit_mask, sets min/max length
//		lValueTypeArr.add("ASCII_Numeric_Base8");
		lValueTypeArr.add("ASCII_Real");
		
		valArr = new ArrayList <String> (); 
		valClassArr = new ArrayList <PDSObjDefn> (); 
		allowedUnitId = new ArrayList <String> ();
		permValueArr = new ArrayList <PermValueDefn> ();
		permValueExtArr = new ArrayList <PermValueExtDefn> ();
		valueDependencyMap = new TreeMap <String, String> ();
		
		deDataIdentifier = "TBD_deDataIdentifier";				// data element
		decDataIdentifier = "TBD_decDataIdentifier";			// data element concept
		ecdDataIdentifier = "TBD_ecdDataIdentifier";			// enumerated conceptual domain 
		necdDataIdentifier = "TBD_necdDataIdentifier";			// non enumerated conceptual domain 
		evdDataIdentifier = "TBD_evdDataIdentifier";			// enumerated value domain
		nevdDataIdentifier = "TBD_nevdDataIdentifier";			// non enumerated value domain
		pvDataIdentifier = "TBD_pvDataIdentifier";				// permissible value
		vmDataIdentifier = "TBD_vmDataIdentifier";				// value meaning

		desDataIdentifier = "TBD_desDataIdentifier";			// designation 
		defDataIdentifier = "TBD_defDataIdentifier";			// definition
		lsDataIdentifier = "TBD_lsDataIdentifier";				// language section 
		teDataIdentifier = "TBD_teDataIdentifier";				// terminlogical entry			
		prDataIdentifier = "TBD_prDataIdentifier";				// property			
		
		administrationRecordValue = "TBD_administrationRecordValue";           
		versionIdentifierValue = "TBD_versionIdentifierValue";                                                      
		registeredByValue = "TBD_registeredByValue";                   
		registrationAuthorityIdentifierValue = "TBD_registrationAuthorityIdentifierValue";
		expressedByArr = null;		// DE -> expressedBy -> DEC
		representing1Arr = null;	// DE -> representing -> EVD or NEVD
		representedBy1Arr = new ArrayList <String>();	// VD -> representedBy -> CD;   aka has_CD
		representedBy2Arr = new ArrayList <String>();	// VD -> representedBy -> DE;   aka has_DE
		containedIn1Arr = new ArrayList <String>();	    // VD -> containedIn1 -> VM/PV;   aka has_VM
		genClassArr = null;
		sysClassArr = null;
	}
	
	public void setIdentifier(String lNameSpaceIdNC, String lTitle, String lNameSpaceIdNC2, String lTitle2) {
		this.identifier = DMDocument.registrationAuthorityIdentifierValue + "." + lNameSpaceIdNC + "." + lTitle + "." + lNameSpaceIdNC2 + "." + lTitle2;
	}

	public void createDOMAttrSingletons (AttrDefn lOldAttr) {
		rdfIdentifier = lOldAttr.rdfIdentifier; 
		identifier = lOldAttr.identifier; 
		versionId = lOldAttr.versionId; 
		sequenceId = lOldAttr.uid; 
		
		title = lOldAttr.title; 
		definition = lOldAttr.description;
		
		registrationStatus = lOldAttr.registrationStatus; 
//		isDeprecated = lOldAttr.isDeprecated; 
		
		regAuthId = lOldAttr.regAuthId; 
		steward = lOldAttr.steward; 
		nameSpaceId = lOldAttr.attrNameSpaceId;
		nameSpaceIdNC = lOldAttr.attrNameSpaceIdNC;

		nsTitle = lOldAttr.nsTitle; 
		sort_identifier = lOldAttr.sort_identifier; 
//		attrAnchorString = lOldAttr.attrAnchorString;
		anchorString = lOldAttr.attrAnchorString;

		XMLSchemaName = lOldAttr.XMLSchemaName; 
		classSteward = lOldAttr.classSteward; 
		classNameSpaceIdNC = lOldAttr.classNameSpaceIdNC;
		submitter = lOldAttr.submitter; 
		subModelId = lOldAttr.subModelId; 
		parentClassTitle = lOldAttr.parentClassTitle;
		classConcept = lOldAttr.classConcept; 
		dataConcept = lOldAttr.dataConcept; 
		classWord = lOldAttr.classWord; 

		lddLocalIdentifier = lOldAttr.lddLocalIdentifier; 
//		 AttrDefn lddUserAttribute = lOldAttr.lddUserAttribute; 
		 
		xmlBaseDataType = lOldAttr.xmlBaseDataType; 
		protValType = lOldAttr.protValType; 
		propType = lOldAttr.propType; 
		valueType = lOldAttr.valueType; 
		groupName = lOldAttr.groupName; 
		cardMin = lOldAttr.cardMin;
		cardMax = lOldAttr.cardMax;
		cardMinI = lOldAttr.cardMinI;
		cardMaxI = lOldAttr.cardMaxI;
		 
		minimum_characters = lOldAttr.minimum_characters; 
		maximum_characters = lOldAttr.maximum_characters; 
		minimum_value = lOldAttr.minimum_value; 
		maximum_value = lOldAttr.maximum_value; 
		format = lOldAttr.format; 
		pattern = lOldAttr.pattern; 
		unit_of_measure_type = lOldAttr.unit_of_measure_type; 
		default_unit_id = lOldAttr.default_unit_id; 
		unit_of_measure_precision = lOldAttr.unit_of_measure_precision; 
		 
		isAttribute = lOldAttr.isAttribute; 
		isOwnedAttribute = lOldAttr.isOwnedAttribute; 
		isPDS4 = lOldAttr.isPDS4; 
		 
		isEnumerated = lOldAttr.isEnumerated;
		isUsedInClass = lOldAttr.isUsedInClass; 
		isRestrictedInSubclass = lOldAttr.isRestrictedInSubclass;
		isMeta = lOldAttr.isMeta;
		hasAttributeOverride = lOldAttr.hasAttributeOverride;
		isNilable = lOldAttr.isNilable;
		isChoice = lOldAttr.isChoice; 
		isAny = lOldAttr.isAny; 
		isFromLDD = lOldAttr.isFromLDD; 
		hasRetiredValue = lOldAttr.hasRetiredValue; 
		
		InitStringArr (this.valArr, lOldAttr.valArr);
		InitStringArr (this.allowedUnitId, lOldAttr.allowedUnitId);
		
/*		
		 ArrayList <String> valArr = lOldAttr.valArr;
		 ArrayList <PDSObjDefn> valClassArr = lOldAttr.valClassArr; 
		 ArrayList <String> allowedUnitId = lOldAttr.allowedUnitId; 
		 HashMap <String, ArrayList<String>> genAttrMap = lOldAttr.genAttrMap; 
		 ArrayList <PermValueDefn> permValueArr = lOldAttr.permValueArr;
		 ArrayList <PermValueExtDefn> permValueExtArr = lOldAttr.permValueExtArr;
		 TreeMap <String, TermEntryDefn> termEntryMap = lOldAttr.termEntryMap;
		 TreeMap <String, String> valueDependencyMap = lOldAttr.valueDependencyMap;
		 */
		 
		dataIdentifier = lOldAttr.dataIdentifier; 
		deDataIdentifier = lOldAttr.deDataIdentifier; 
		decDataIdentifier = lOldAttr.decDataIdentifier; 
		ecdDataIdentifier = lOldAttr.ecdDataIdentifier; 
		evdDataIdentifier = lOldAttr.evdDataIdentifier; 
		necdDataIdentifier = lOldAttr.necdDataIdentifier; 
		nevdDataIdentifier = lOldAttr.nevdDataIdentifier; 
		pvDataIdentifier = lOldAttr.pvDataIdentifier; 
		vmDataIdentifier = lOldAttr.vmDataIdentifier; 
		 
		desDataIdentifier = lOldAttr.desDataIdentifier; 
		defDataIdentifier = lOldAttr.defDataIdentifier; 
		lsDataIdentifier = lOldAttr.lsDataIdentifier; 
		teDataIdentifier = lOldAttr.teDataIdentifier; 
		prDataIdentifier = lOldAttr.prDataIdentifier; 
		 
		administrationRecordValue = lOldAttr.administrationRecordValue;
		versionIdentifierValue = lOldAttr.versionIdentifierValue;
		registeredByValue = lOldAttr.registeredByValue;
		registrationAuthorityIdentifierValue = lOldAttr.registrationAuthorityIdentifierValue;
		
		
		InitStringArr (this.expressedByArr, lOldAttr.expressedByArr);
		InitStringArr (this.representing1Arr, lOldAttr.representing1Arr);
		InitStringArr (this.representedBy1Arr, lOldAttr.representedBy1Arr);
		InitStringArr (this.representedBy2Arr, lOldAttr.representedBy2Arr);
		InitStringArr (this.containedIn1Arr, lOldAttr.containedIn1Arr);
		
		InitStringArr (this.genClassArr, lOldAttr.genClassArr);
		InitStringArr (this.sysClassArr, lOldAttr.sysClassArr);
		return;
	}
	
	// copy a string array
	public void InitStringArr (ArrayList <String> lDomStrArr, ArrayList <String> lPDSStrArr) {
		if (lPDSStrArr == null) return;
		for (Iterator <String> i = lPDSStrArr.iterator(); i.hasNext();) {
			String lOldStr = (String) i.next();
			if (lOldStr != null)
				lDomStrArr.add(lOldStr);
			else
				System.out.println(">>error    - InitStringArr - Null DomStr");
		}
	}
	
	//	get the value type for printing. 
	public String getValueType (boolean forceBound) {
		String lValue = this.valueType;
		if (! ((lValue.indexOf("TBD") == 0) || (lValue.compareTo("") == 0))) {
			return lValue;
		}
		if (forceBound) {
			return "ASCII_Short_String_Collapsed";
		}
		return "TBD_value_type";
	}
	
	
	//	get the identifier for this value type
	public String getValueTypeIdentifier () {
		
		// check if there is a value type
		String lValueType = this.valueType;
		if ((lValueType.indexOf("TBD") == 0) || (lValueType.compareTo("") == 0)) return null;

		// get the data type
		String llValueTypeId = DOMInfoModel.getClassIdentifier (DMDocument.masterNameSpaceIdNCLC, lValueType);

		DOMClass lClass = (DOMClass) DOMInfoModel.masterDOMClassIdMap.get(llValueTypeId);
		if (lClass == null) return null;

		return lClass.identifier;
	}	
		
	//	get the minimum_characters for printing. Use the data type for a default.
	public String getMinimumCharacters (boolean useDataTypeForUNK, boolean forceBound) {
		String lValue = this.minimum_characters;
		if (lValue.indexOf("TBD") == 0 && useDataTypeForUNK) {
			DOMDataType lDataType = DOMInfoModel.masterDOMDataTypeTitleMap.get(this.valueType);
			if (lDataType == null) return "TBD_minimum_characters";
			lValue = lDataType.minimum_characters;
		}
		if (forceBound) {
			if (lValue.indexOf("TBD") == 0 || lValue.compareTo("") == 0 || lValue.compareTo("-2147483648") == 0) {
				return "Unbounded";
			}
		}
		if (lValue.compareTo("") == 0) return "TBD_minimum_characters";
		return lValue;
	}
	
	//	get the maximum_characters for printing. Use the data type for a default.
	public String getMaximumCharacters (boolean useDataTypeForUNK, boolean forceBound) {
		String lValue = this.maximum_characters;
		if (lValue.indexOf("TBD") == 0 && useDataTypeForUNK) {
			DOMDataType lDataType = DOMInfoModel.masterDOMDataTypeTitleMap.get(this.valueType);
			if (lDataType == null) return "TBD_maximum_characters";
			lValue = lDataType.maximum_characters;
		}
		if (forceBound) {
			if (lValue.indexOf("TBD") == 0 || lValue.compareTo("") == 0 || lValue.compareTo("2147483647") == 0) {
				return "Unbounded";
			}
		}
		if (lValue.compareTo("") == 0) return "TBD_maximum_characters";
		return lValue;
	}
	
	//	get the minimum_value for printing. Use the data type for a default.
	public String getMinimumValue (boolean useDataTypeForUNK, boolean forceBound) {
		String lValue = this.minimum_value;
		if (lValue.indexOf("TBD") == 0 && useDataTypeForUNK) {
			DOMDataType lDataType = DOMInfoModel.masterDOMDataTypeTitleMap.get(this.valueType);
			if (lDataType == null) return "TBD_minimum_value";
			lValue = lDataType.minimum_value;
		}
		if (forceBound) {
			if (lValue.indexOf("TBD") == 0 || lValue.compareTo("") == 0 || lValue.compareTo("-2147483648") == 0 || lValue.compareTo("-INF") == 0) {
				return "Unbounded";
			}
		}
		if (lValue.compareTo("") == 0) return "TBD_minimum_value";
		return lValue;
	}
	
	//	get the maximum_value for printing. Use the data type for a default.
	public String getMaximumValue (boolean useDataTypeForUNK, boolean forceBound) {
		String lValue = this.maximum_value;
		if (lValue.indexOf("TBD") == 0 && useDataTypeForUNK) {
			DOMDataType lDataType = DOMInfoModel.masterDOMDataTypeTitleMap.get(this.valueType);
			if (lDataType == null) return "TBD_maximum_value";
			lValue = lDataType.maximum_value;
		}
		if (forceBound) {
			if (lValue.indexOf("TBD") == 0 || lValue.compareTo("") == 0 || lValue.compareTo("2147483647") == 0 || lValue.compareTo("4294967295") == 0 || lValue.compareTo("INF") == 0) {
				return "Unbounded";
			}
		}
		if (lValue.compareTo("") == 0) return "TBD_maximum_value";
		return lValue;
	}

	//	get the format for printing. Use the data type for a default.
	public String getFormat (boolean useDataTypeForUNK) {
		String lValue = this.format;
		if (! ((lValue.indexOf("TBD") == 0) || (lValue.compareTo("") == 0))) {
			return lValue;
		}
		if (useDataTypeForUNK) {
			DOMDataType lDataType = DOMInfoModel.masterDOMDataTypeTitleMap.get(this.valueType);
			if (lDataType != null) {
				lValue = lDataType.formation_rule;
				if (! (lValue.indexOf("TBD") == 0)) {
					return lValue;
				}
			}
		}
		return "TBD_format";
	}
	
	//	get the maximum_value for printing. Use the data type for a default.
	public String getPattern (boolean useDataTypeForUNK) {
		String lValue = this.pattern;
		if (lValue.indexOf("TBD") == 0 && useDataTypeForUNK) {
			DOMDataType lDataType = DOMInfoModel.masterDOMDataTypeTitleMap.get(this.valueType);
			if (lDataType == null) return "TBD_pattern";
			if (lDataType.pattern.isEmpty()) return "TBD_pattern";
			if (lDataType.pattern.size() > 1) return "TBD_pattern";
			lValue = lDataType.pattern.get(0);
		}
		if (lValue.compareTo("") == 0) return "TBD_pattern";
		return lValue;
	}	

	//	get the unit_of_measure_type for printing.
	public String getUnitOfMeasure (boolean forceBound) {
		String lValue = this.unit_of_measure_type;
		if (! ((lValue.indexOf("TBD") == 0) || (lValue.compareTo("") == 0))) {
			return DOMInfoModel.unEscapeProtegeString(lValue);
		}
		if (forceBound) {
			return "Units_of_None";
		}
		return "TBD_unit_of_measure_type";			
	}
	
	//	get the identifier for this Unit Of Measure
	public String getUnitOfMeasureIdentifier () {
		
		// check if there is a UnitOfMeasure
		String lUnitOfMeasure = this.unit_of_measure_type;
		if ((lUnitOfMeasure.indexOf("TBD") == 0) || (lUnitOfMeasure.compareTo("") == 0)) return null;

		// get the unit of measure type
		String lUnitOfMeasureId = DOMInfoModel.getClassIdentifier (DMDocument.masterNameSpaceIdNCLC, lUnitOfMeasure);

		DOMClass lClass = (DOMClass) DOMInfoModel.masterDOMClassIdMap.get(lUnitOfMeasureId);
		if (lClass == null) return null;

		return lClass.identifier;
	}

	//	get the units for this unit_of_measure_type.
	public String getUnits (boolean needsQuotes) {
		// check if there is a unit of measure type
		String lUnitOfMeasureType = this.unit_of_measure_type;
		if ((lUnitOfMeasureType.indexOf("TBD") == 0) || (lUnitOfMeasureType.compareTo("") == 0)) return null;

		String lUnitsValueString = "";

		// get the unit of measure type
		DOMUnit lDOMUnit = (DOMUnit) DOMInfoModel.masterDOMUnitTitleMap.get(lUnitOfMeasureType);
		if (lDOMUnit == null) return null;

		// check if there are any permissible values
		if ((lDOMUnit.unit_id == null || lDOMUnit.unit_id.isEmpty()))  return null;
		
		// create the value string
		String lDel = "";
		for (Iterator <String> k = lDOMUnit.unit_id.iterator(); k.hasNext();) {
			String lValue = (String) k.next();
			if (needsQuotes) {
				lValue = "'" + lValue + "'";
			}
			lUnitsValueString += lDel + lValue;
			lDel = ", ";
		}
		return lUnitsValueString;
	}
		
	//	get the default_unit_id (specified unit) for printing.
	public String getDefaultUnitId (boolean forceBound) {
		String lValue = this.default_unit_id;
		if (! ((lValue.indexOf("TBD") == 0) || (lValue.compareTo("") == 0))) {
			return DOMInfoModel.unEscapeProtegeString(lValue);
		}
		if (forceBound) {
			return "none";
		}
		return "TBD_default_unit_id";
	}	
	
	//	get the steward for printing.
	public String getSteward () {
		String lValue = this.steward;
		if (! ((lValue.indexOf("TBD") == 0) || (lValue.compareTo("") == 0))) {
			return lValue;
		}
		return "TBD_steward";
	}	

	/*
	//	get the name space id for printing.
	public String getNameSpaceId () {
		String lValue = this.nameSpaceIdNC;
		if (! ((lValue.indexOf("TBD") == 0) || (lValue.compareTo("") == 0))) {
			return lValue;
		}
		return "TBD_namespace_id";
	}
	*/
	
	//	get the classConcept for printing.
	public String getClassConcept () {
		String lValue = this.classConcept;
		if (! ((lValue.indexOf("TBD") == 0) || (lValue.compareTo("") == 0))) {
			return lValue;
		}
		return "TBD_class_concept";
	}
	
	//	get the dataConcept for printing.
	public String getDataConcept () {
		String lValue = this.dataConcept;
		if (! ((lValue.indexOf("TBD") == 0) || (lValue.compareTo("") == 0))) {
			return lValue;
		}
		return "TBD_data_concept";
	}

	public void set11179Attr (String lDataIdentifier) {
		// Data Element Identifiers	
		dataIdentifier = lDataIdentifier;
		deDataIdentifier = "DE." + lDataIdentifier;				// data element
		decDataIdentifier = "DEC." + lDataIdentifier;			// data element concept
		ecdDataIdentifier = "ECD." + lDataIdentifier;			// enumerated conceptual domain 
		necdDataIdentifier = "NECD." + lDataIdentifier;			// non enumerated conceptual domain 
		evdDataIdentifier = "EVD." + lDataIdentifier;			// enumerated value domain
		nevdDataIdentifier = "NEVD." + lDataIdentifier;			// non enumerated value domain
		pvDataIdentifier = "PV." + lDataIdentifier;				// permissible value
		vmDataIdentifier = "VM." + lDataIdentifier;				// value meaning

		desDataIdentifier = "DES." + lDataIdentifier;			// designation 
		defDataIdentifier = "DEF." + lDataIdentifier;			// definition
		lsDataIdentifier = "LS." + lDataIdentifier;				// language section 
		teDataIdentifier = "TE." + lDataIdentifier;				// terminological entry		
		prDataIdentifier = "PR." + lDataIdentifier;				// property 	
	}
	
	public void sortPermissibleValues () {
		//	sort the permissible value and set order
		TreeMap <String, DOMPermValDefn> lOrderedDOMPermValMap = new TreeMap <String, DOMPermValDefn> ();
		TreeMap <String, DOMProp> lOrderedDOMPropMap = new TreeMap <String, DOMProp> ();
		for (Iterator <DOMProp> i = domPermValueArr.iterator(); i.hasNext();) {
			DOMProp lDOMProp = (DOMProp) i.next();
			if (lDOMProp.hasDOMObject != null && lDOMProp.hasDOMObject instanceof DOMPermValDefn) {
				DOMPermValDefn lDOMPermVal = (DOMPermValDefn) lDOMProp.hasDOMObject;
				lOrderedDOMPermValMap.put(lDOMPermVal.value, lDOMPermVal);
				lOrderedDOMPropMap.put(lDOMPermVal.value, lDOMProp);
			}
		}
		domPermValueArr.clear();
		Integer lClassOrder = 1010;
		ArrayList <DOMPermValDefn> lDOMPermValArr = new ArrayList <DOMPermValDefn> (lOrderedDOMPermValMap.values());
		for (Iterator <DOMPermValDefn> i = lDOMPermValArr.iterator(); i.hasNext();) {
			DOMPermValDefn lDOMPermVal = (DOMPermValDefn) i.next();
			String lValue = lDOMPermVal.value;
			DOMProp lDOMProp = lOrderedDOMPropMap.get(lValue);
			if (lDOMProp != null) {
				domPermValueArr.add(lDOMProp);
				String lClassOrderString = lClassOrder.toString();
				lDOMProp.classOrder = lClassOrderString;
//				System.out.println("debug sortPermissibleValues  lDOMAttr.identifier:" + identifier + " - " + "lDOMPermVal.value:" + lDOMPermVal.value + " - " + "lDOMProp.classOrder:" + lDOMProp.classOrder);		
			}
			lClassOrder += 10;
		}
	}
	
	public void setIsCharDataType () {
		// if the valueType is not a character, set setIsCharDataType false
		// the XML Schema writer writes only min/max character for character types, min/max value for non-character
		if (lValueTypeArr.contains(valueType)) {
			isCharDataType = false;
		}
	}
	
	// clone an attribute 
	public void cloneAttr (DOMAttr lOrgAttr) {
//		AttrDefn lNewAttr = new AttrDefn (lRDFIdentifier);				              					              
		this.sequenceId = lOrgAttr.sequenceId;										              
		this.identifier = lOrgAttr.identifier; 						              
		this.sort_identifier = lOrgAttr.sort_identifier;				              
//		this.attrAnchorString = lOrgAttr.attrAnchorString;			              
		this.title = lOrgAttr.title;  								              
		this.versionId = lOrgAttr.versionId;							              
		this.registrationStatus = lOrgAttr.registrationStatus;		              
		this.XMLSchemaName = lOrgAttr.XMLSchemaName;					              
		this.regAuthId = lOrgAttr.regAuthId;							              
		this.steward = lOrgAttr.steward;								              
		this.classSteward = lOrgAttr.classSteward;					              
		this.nameSpaceId = lOrgAttr.nameSpaceId;                     
		this.nameSpaceIdNC = lOrgAttr.nameSpaceIdNC;                   
		this.classNameSpaceIdNC = lOrgAttr.classNameSpaceIdNC;                  
		this.submitter = lOrgAttr.submitter;							              
		this.subModelId = lOrgAttr.subModelId;						              
		this.parentClassTitle = lOrgAttr.parentClassTitle;							              
		this.attrParentClass = lOrgAttr.attrParentClass;							              
		this.classConcept = lOrgAttr.classConcept;					              
		this.dataConcept = lOrgAttr.dataConcept;						              
		this.classWord = lOrgAttr.classWord;							              
		this.definition = lOrgAttr.definition;                         
		this.lddLocalIdentifier = lOrgAttr.lddLocalIdentifier;		              

		this.xmlBaseDataType = lOrgAttr.xmlBaseDataType;				              
		this.protValType = lOrgAttr.protValType;						              
		this.propType = lOrgAttr.propType;							              
		this.valueType = lOrgAttr.valueType;
		this.groupName = lOrgAttr.groupName;
		this.cardMin = lOrgAttr.cardMin;                             
		this.cardMax = lOrgAttr.cardMax;                             
		this.cardMinI = lOrgAttr.cardMinI;                            
		this.cardMaxI = lOrgAttr.cardMaxI;                            

		this.minimum_characters = lOrgAttr.minimum_characters;		              
		this.maximum_characters = lOrgAttr.maximum_characters;		              
		this.minimum_value = lOrgAttr.minimum_value;			                  
		this.maximum_value = lOrgAttr.maximum_value;			                  
		this.format = lOrgAttr.format;					                    
		this.pattern = lOrgAttr.pattern;					                    
		this.unit_of_measure_type = lOrgAttr.unit_of_measure_type;	              
		this.default_unit_id = lOrgAttr.default_unit_id;			                
		this.unit_of_measure_precision = lOrgAttr.unit_of_measure_precision;	          

//		this.type = lOrgAttr.type;                                
		this.isAttribute = lOrgAttr.isAttribute;			                    
		this.isOwnedAttribute = lOrgAttr.isOwnedAttribute;		                
		this.isPDS4 = lOrgAttr.isPDS4;					                    
// 445		this.isUnitOfMeasure = lOrgAttr.isUnitOfMeasure;                     
// 445		this.isDataType = lOrgAttr.isDataType;                          
		this.isEnumerated = lOrgAttr.isEnumerated;                        
		this.isUsedInClass = lOrgAttr.isUsedInClass;			                  
		this.isRestrictedInSubclass = lOrgAttr.isRestrictedInSubclass;              
		this.isMeta = lOrgAttr.isMeta;                              
		this.hasAttributeOverride = lOrgAttr.hasAttributeOverride;                
		this.isNilable = lOrgAttr.isNilable;                           
		this.isChoice = lOrgAttr.isChoice;				                    
		this.isAny = lOrgAttr.isAny;				                    
		this.isFromLDD = lOrgAttr.isFromLDD;			                      
		this.hasRetiredValue = lOrgAttr.hasRetiredValue;                     

		this.valArr = lOrgAttr.valArr;                              
		this.allowedUnitId = lOrgAttr.allowedUnitId;	                      
		this.genAttrMap = lOrgAttr.genAttrMap;                          
		this.permValueArr = lOrgAttr.permValueArr;                        
		this.permValueExtArr = lOrgAttr.permValueExtArr;                     
		this.termEntryMap = lOrgAttr.termEntryMap;                        
		this.valueDependencyMap = lOrgAttr.valueDependencyMap;                  
		 	                                            
		this.dataIdentifier = lOrgAttr.dataIdentifier; 						          
		this.deDataIdentifier = lOrgAttr.deDataIdentifier;					          
		this.decDataIdentifier = lOrgAttr.decDataIdentifier;					          
		this.ecdDataIdentifier = lOrgAttr.ecdDataIdentifier;					          
		this.evdDataIdentifier = lOrgAttr.evdDataIdentifier;					          
		this.necdDataIdentifier = lOrgAttr.necdDataIdentifier;				          
		this.nevdDataIdentifier = lOrgAttr.nevdDataIdentifier;				          
		this.pvDataIdentifier = lOrgAttr.pvDataIdentifier;					          
		this.vmDataIdentifier = lOrgAttr.vmDataIdentifier;					          
		 	                                            
		this.desDataIdentifier = lOrgAttr.desDataIdentifier;					          
		this.defDataIdentifier = lOrgAttr.defDataIdentifier;					          
		this.lsDataIdentifier = lOrgAttr.lsDataIdentifier;					          
		this.teDataIdentifier = lOrgAttr.teDataIdentifier;					          
		this.prDataIdentifier = lOrgAttr.prDataIdentifier;					          
		 	                                            
		this.administrationRecordValue = lOrgAttr.administrationRecordValue;           
		this.versionIdentifierValue = lOrgAttr.versionIdentifierValue;              
		this.registeredByValue = lOrgAttr.registeredByValue;                   
		this.registrationAuthorityIdentifierValue = lOrgAttr.registrationAuthorityIdentifierValue;
		 	                                            
		this.expressedByArr = lOrgAttr.expressedByArr;                      
		this.representing1Arr = lOrgAttr.representing1Arr;                    
		this.representedBy1Arr = lOrgAttr.representedBy1Arr;                   
		this.representedBy2Arr = lOrgAttr.representedBy2Arr;                   
		this.containedIn1Arr = lOrgAttr.containedIn1Arr;                     
		 	                                            
		this.genClassArr = lOrgAttr.genClassArr;                         
		this.sysClassArr = lOrgAttr.sysClassArr;	                       
		return;
	}
	
	// finish the clone of an attribute 
	public void finishCloneAttr (DOMAttr lOrgAttr) {				              					              
//		this.uid = lOrgAttr.uid;										              
//		this.identifier = lOrgAttr.identifier; 						              
//		this.sort_identifier = lOrgAttr.sort_identifier;				              
//		this.attrAnchorString = lOrgAttr.attrAnchorString;			              
//		this.title = lOrgAttr.title;  								              
//		this.versionId = lOrgAttr.versionId;							              
//		this.registrationStatus = lOrgAttr.registrationStatus;		              
		this.XMLSchemaName = lOrgAttr.XMLSchemaName;					              
//		this.regAuthId = lOrgAttr.regAuthId;							              
		this.steward = lOrgAttr.steward;								              
//		this.classSteward = lOrgAttr.classSteward;					              
//		this.attrNameSpaceId = lOrgAttr.attrNameSpaceId;                     
//		this.attrNameSpaceIdNC = lOrgAttr.attrNameSpaceIdNC;                   
//		this.classNameSpaceIdNC = lOrgAttr.classNameSpaceIdNC;                  
//		this.submitter = lOrgAttr.submitter;							              
//		this.subModelId = lOrgAttr.subModelId;						              
//		this.className = lOrgAttr.className;							              
//		this.classConcept = lOrgAttr.classConcept;					              
		this.dataConcept = lOrgAttr.dataConcept;						              
//		this.classWord = lOrgAttr.classWord;							              
		this.definition = lOrgAttr.definition;                         
		this.lddLocalIdentifier = lOrgAttr.lddLocalIdentifier;		              

		this.xmlBaseDataType = lOrgAttr.xmlBaseDataType;				              
		this.protValType = lOrgAttr.protValType;						              
		this.propType = lOrgAttr.propType;							              
		this.valueType = lOrgAttr.valueType;	
		this.groupName = lOrgAttr.groupName;

//		this.cardMin = lOrgAttr.cardMin;                             
//		this.cardMax = lOrgAttr.cardMax;                             
//		this.cardMinI = lOrgAttr.cardMinI;                            
//		this.cardMaxI = lOrgAttr.cardMaxI;                            

		this.minimum_characters = lOrgAttr.minimum_characters;		              
		this.maximum_characters = lOrgAttr.maximum_characters;		              
		this.minimum_value = lOrgAttr.minimum_value;			                  
		this.maximum_value = lOrgAttr.maximum_value;			                  
		this.format = lOrgAttr.format;					                    
		this.pattern = lOrgAttr.pattern;					                    
		this.unit_of_measure_type = lOrgAttr.unit_of_measure_type;	              
		this.default_unit_id = lOrgAttr.default_unit_id;			                
		this.unit_of_measure_precision = lOrgAttr.unit_of_measure_precision;	          

//		this.type = lOrgAttr.type;                                
		this.isAttribute = lOrgAttr.isAttribute;			                    
		this.isOwnedAttribute = lOrgAttr.isOwnedAttribute;		                
		this.isPDS4 = lOrgAttr.isPDS4;					                    
//		this.isUnitOfMeasure = lOrgAttr.isUnitOfMeasure;                     
//		this.isDataType = lOrgAttr.isDataType;                          
		this.isEnumerated = lOrgAttr.isEnumerated;                        
		this.isUsedInClass = lOrgAttr.isUsedInClass;			                  
		this.isRestrictedInSubclass = lOrgAttr.isRestrictedInSubclass;              
		this.isMeta = lOrgAttr.isMeta;                              
		this.hasAttributeOverride = lOrgAttr.hasAttributeOverride;                
		this.isNilable = lOrgAttr.isNilable;                           
		this.isChoice = lOrgAttr.isChoice;				                    
		this.isAny = lOrgAttr.isAny;				                    
//		this.isFromLDD = lOrgAttr.isFromLDD;			                      
		this.hasRetiredValue = lOrgAttr.hasRetiredValue;                     

		this.valArr = lOrgAttr.valArr;                              
		this.allowedUnitId = lOrgAttr.allowedUnitId;	                      
		this.genAttrMap = lOrgAttr.genAttrMap;                          
		this.permValueArr = lOrgAttr.permValueArr;                        
		this.permValueExtArr = lOrgAttr.permValueExtArr;                     
		this.termEntryMap = lOrgAttr.termEntryMap;                        
		this.valueDependencyMap = lOrgAttr.valueDependencyMap;                  
		 	                                            
//		this.dataIdentifier = lOrgAttr.dataIdentifier; 						          
//		this.deDataIdentifier = lOrgAttr.deDataIdentifier;					          
//		this.decDataIdentifier = lOrgAttr.decDataIdentifier;					          
//		this.ecdDataIdentifier = lOrgAttr.ecdDataIdentifier;					          
//		this.evdDataIdentifier = lOrgAttr.evdDataIdentifier;					          
//		this.necdDataIdentifier = lOrgAttr.necdDataIdentifier;				          
//		this.nevdDataIdentifier = lOrgAttr.nevdDataIdentifier;				          
//		this.pvDataIdentifier = lOrgAttr.pvDataIdentifier;					          
//		this.vmDataIdentifier = lOrgAttr.vmDataIdentifier;					          
		 	                                            
//		this.desDataIdentifier = lOrgAttr.desDataIdentifier;					          
//		this.defDataIdentifier = lOrgAttr.defDataIdentifier;					          
//		this.lsDataIdentifier = lOrgAttr.lsDataIdentifier;					          
//		this.teDataIdentifier = lOrgAttr.teDataIdentifier;					          
//		this.prDataIdentifier = lOrgAttr.prDataIdentifier;					          
		 	                                            
		this.administrationRecordValue = lOrgAttr.administrationRecordValue;           
		this.versionIdentifierValue = lOrgAttr.versionIdentifierValue;              
		this.registeredByValue = lOrgAttr.registeredByValue;                   
		this.registrationAuthorityIdentifierValue = lOrgAttr.registrationAuthorityIdentifierValue;
		 	                                            
		this.expressedByArr = lOrgAttr.expressedByArr;                      
		this.representing1Arr = lOrgAttr.representing1Arr;                    
		this.representedBy1Arr = lOrgAttr.representedBy1Arr;                   
		this.representedBy2Arr = lOrgAttr.representedBy2Arr;                   
		this.containedIn1Arr = lOrgAttr.containedIn1Arr;                     
		 	                                            
		this.genClassArr = lOrgAttr.genClassArr;                         
		this.sysClassArr = lOrgAttr.sysClassArr;	                       
		return;
	}	
}
