/**
 * 
 */
package help;

import java.util.Arrays;
import java.util.List;

/**
 * @author harinder
 *
 */
public class Constants {
	// private static final List<String> INVALID_NEXT_WORDS = Arrays.asList(new
	// String[] {"BC", "bc", "years", "Years", "YEARS", ".", ",", "days",
	// "Days", "AD", "A", "ad"});
	public static final List<String> INVALID_NEXT_WORDS = Arrays
			.asList(new String[] { "BC", "bc", "years", "Years", "YEARS",
					"days", "Days", "AD", "A", "ad", "A." , "a", "b", "c", 
					"January", "February", "March", "April", "May", "June", "July"
					, "August", "September", "October", "November", "December"
					,"january", "february", "march", "april", "may", "june", "july"
					, "august", "september", "october", "november", "december",
					"Jan", "Feb", "Mar", "Apr", "Jun", "Jul"
					, "Aug", "Sept", "Sep", "Oct", "Nov", "Dec",
					"jan", "feb", "mar", "apr", "jun", "jul"
					, "aug", "sept", "sep", "oct", "nov", "dec", "minutes", "Part", "part", "times",
					"minute", "weeks", "days", "hours", "AM", "PM", "am", "pm", "years", "year", "or", "and",
					"o", "Page", "page", "Years", "Year" , "seconds", "Seconds", "Months", "months", "b."});
	
	public static final List<String> INVALID_PREV_WORDS = Arrays
			.asList(new String[] { "Figure", "fig", "section", "fig.", "Fig.", 
					"Table", "table", "'", "Example", "example", "eg.", "System", "system",
					"article", "Article", "type", "Section", "task", "Task", "age", "Age"});
	
	public static final String KEYWORDS[] = { "population", "people",
			"inhabitants", "natives", "residents", "people", "area", "land",
			"large", "largest", "foreign", "fdi", "direct", "investments",
			"investment", "goods", "exports", "export", "exporter", "exported",
			"ships", "shipped", "electricity", "kilowatthors", "terawatt",
			"generation", "production", "sector", "carbon", "emission", "CO2",
			"co2", "emissions", "kilotons", "Inflation", "Price", "Rise",
			"rate", "Internet", "users", "usage", "penetration", "use", "user",
			"Gross", "domestic", "GDP", "gdp", "product", "life", "expectancy",
			"deaths", "rose" };

	public static final String COUNTRIES[] = { "Afghan", "Afghanistan",
			"Albania", "Albanian", "Algeria", "Algerian", "America",
			"American", "Americans", "American Samoa", "Andorra", "Andorran",
			"Angola", "Angolan", "Anguilla", "Antigua and Barbuda", "Arabia",
			"Arabian", "Argentina", "Argentine", "Argentinean", "Argentinian",
			"Armenia", "Armenian", "Aruba", "Aussie", "Australia",
			"Australian", "Austria", "Austrian", "Azerbaijan", "Azerbaijani",
			"Bahamas", "Bahrain", "Bahraini", "Bahrainian", "Bangladesh",
			"Bangladeshi", "Barbados", "Belarus", "Belarusian", "Belgian",
			"Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bhutani",
			"Bolivia", "Bolivian", "Bosnia and Herzegovina", "Bosnian",
			"Botswana", "Brazil", "Brazilian", "Britain", "British",
			"British Indian Ocean Territory", "British Virgin Islands",
			"Brunei", "Bulgaria", "Bulgarian", "Burkina Faso", "Burundi",
			"Cambodia", "Cambodian", "Cameroon", "Cameroonean", "Cameroonian",
			"Canada", "Canadian", "Canadians", "Cape Verde", "Cayman Islands",
			"Central African Republic", "Chad", "Chile", "China", "Chinese",
			"Christmas Island", "Cocos (Keeling) Islands", "Colombia",
			"Colombian", "Comoros", "Congo", "Congo", "Cook Islands",
			"Costa Rica", "Costa Rican", "Côte d’Ivoire", "Croatia",
			"Croatian", "Cuba", "Cuban", "Cyprus", "Czech", "Czech",
			"Czechoslovakia", "Czechoslovakian", "Czech Republic", "Danish",
			"Democratic Republic of the Congo", "Denmark", "Deutschland",
			"Djibouti", "Dominica", "Dominican", "Dominican Republic", "Dutch",
			"Ecuador", "Ecuadorian", "Egypt", "Egyptian", "El Salvador",
			"England", "English", "Equatorial Guinea", "Eritrea", "Eritrean",
			"Estonia", "Estonian", "Ethiopia", "Ethiopian", "Falkland Islands",
			"Federated States of Micronesia", "Fiji", "Fijian", "Filipino",
			"Finland", "Finnish", "France", "French", "French Polynesia",
			"Gambia", "Georgia", "Georgian", "German", "Germany", "Ghana",
			"Ghanian", "Gibraltar", "Greece", "Greek", "Greenland", "Grenada",
			"Guadeloupe", "Guam", "Guatemala", "Guatemalan", "Guernsey",
			"Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Holland",
			"Honduras", "Hondurasian", "Hong Kong", "Hungarian", "Hungary",
			"Iceland", "Icelandic", "India", "Indian", "Indonesia",
			"Indonesian", "Iran", "Irani", "Iranian", "Iraq", "Iraqi",
			"Ireland", "Irish", "Isle of Man", "Israel", "Israeli", "Italian",
			"Italy", "Ivory Coast", "Jamaica", "Jamaican", "Japan", "Japanese",
			"Jersey", "Jordan", "Jordanian", "Kazakh", "Kazakhstan",
			"Kazakhstani", "Kenya", "Kenyan", "Kiribati", "Kiwi", "Kuwait",
			"Kuwaiti", "Lanka", "Lankan", "Laos", "Latvia", "Latvian",
			"Lebanon", "Lesotho", "Liberia", "Liberian", "Libya", "Libyan",
			"Liechtenstein", "Lithuania", "Lithuanian", "Luxembourg", "Macau",
			"Madagascan", "Madagascar", "Malawi", "Malawian", "Malaysia",
			"Malaysian", "Maldives", "Maldivian", "Mali", "Malta", "Maltese",
			"Malti", "Marshall Islands", "Martinique", "Mauritania",
			"Mauritanian", "Mauritian", "Mauritius", "Mayotte", "Mexican",
			"Mexico", "Moldova", "Moldovan", "Monaco", "Mongolia", "Mongolian",
			"Montenegro", "Montergrin", "Montserrat", "Moroccan", "Morocco",
			"Mozambican", "Mozambique", "Myanmar", "Myanmarese", "Myanmari",
			"Namibia", "Namibian", "Nauru", "Nepal", "Nepalese", "Nepali",
			"Netherlands", "Netherlands Antilles", "New Caledonia",
			"New Zealand", "Nicaragua", "Nicaraguan", "Niger", "Nigeria",
			"Niue", "Norfolk Island", "North", "Northern Ireland",
			"Northern Mariana Islands", "Norway", "Norwegian", "Oman", "Omani",
			"Pakistan", "Pakistani", "Palau", "Panama", "Panamian",
			"Papua New Guinea", "Paraguay", "Paraguayan", "Peru", "Peruvian",
			"Philipino", "Philippines", "Pitcairn Islands", "Poland", "Polish",
			"Portugal", "Portugese", "Puerto Rico", "Qatar", "Qatari",
			"Republic of Macedonia", "Romania", "Romanian", "Russia",
			"Russian", "Russian Empire", "Rwanda", "Rwandan",
			"Saint Kitts and Nevis", "Saint Lucia",
			"Saint Pierre and Miquelon", "Saint Vincent and the Grenadines",
			"Samoa", "San Marino", "São Tomé and Príncipe", "Saudi Arabia",
			"Scot", "Scotland", "Scott", "Scottish", "Senegal", "Senegalese",
			"Serb", "Serbia", "Serbian", "Seychelles", "Sierra Leone",
			"Singapore", "Singaporean", "Slovakia", "Slovakian", "Slovenia",
			"Slovenian", "Solomon Islands", "Somalia", "Somalian", "South",
			"South Africa", "South African",
			"South Georgia and the South Sandwich Islands", "Spain", "Spanish",
			"Sri Lanka", "Sudan", "Sudanese", "Suriname", "Swaziland",
			"Sweden", "Swedes", "Swedish", "Swiss", "Switzerland", "Syria",
			"Taiwan", "Taiwanese", "Tajikistan", "Tajikistani", "Tanzania",
			"Tanzanian", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga",
			"Tongan", "Trinidad and Tobago", "Tunisia", "Tunisian", "Turkey",
			"Turkish", "Turkmenistan", "Turkmenistani",
			"Turks and Caicos Islands", "Tuvalu", "UAE", "Uganda", "Ugandan",
			"UK", "Ukraine", "Ukrainian", "united", "United",
			"United Arab Emirates", "United Kingdom",
			"United States Minor Outlying Islands",
			"United States Virgin Islands", "Uruguay", "Uruguayan", "US", "US",
			"U.S.", "USA", "USA", "Uzbek", "Uzbeki", "Uzbekistan",
			"Uzbekistani", "Vanuatu", "Vatican", "Vatican", "Vatican City",
			"Venezuela", "Venezuelan", "Vietnam", "Vietnamese", "Wales",
			"Wallis and Futuna", "Weimar Republic", "Western Sahara",
			"West Germany", "Yemen", "Yemenese", "Yemeni", "Yugoslavia",
			"Yugoslavian", "Zambia", "Zambian", "Zimbabwe", "Zimbabwean" };

}
