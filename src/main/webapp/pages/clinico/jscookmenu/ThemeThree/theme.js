var cmThemeThreeBase = '/css/jscookmenu/ThemeThree/';

// the follow block allows user to re-define theme base directory
// before it is loaded.
try
{
    if (myThemeThreeBase)
    {
            cmThemeThreeBase = myThemeThreeBase;
    }
}
catch (e)
{
}

var cmThemeThree =
{
  	// main menu display attributes
  	//
  	// Note.  When the menu bar is horizontal,
  	// mainFolderLeft and mainFolderRight are
  	// put in <span></span>.  When the menu
  	// bar is vertical, they would be put in
  	// a separate TD cell.

  	// HTML code to the left of the folder item
  	mainFolderLeft: '&#160;',
  	// HTML code to the right of the folder item
  	mainFolderRight: '&#160;',
	// HTML code to the left of the regular item
	mainItemLeft: '&#160;',
	// HTML code to the right of the regular item
	mainItemRight: '&#160;',

	// sub menu display attributes

	// 0, HTML code to the left of the folder item
	folderLeft: '',
	// 1, HTML code to the right of the folder item
	folderRight: '',
	// 2, HTML code to the left of the regular item
	itemLeft: '',
	// 3, HTML code to the right of the regular item
	itemRight: '',
	// 4, cell spacing for main menu
	mainSpacing: 0,
	// 5, cell spacing for sub menus
	subSpacing: 0,
	// 6, auto dispear time for submenus in milli-seconds
	delay: 200
};

// for horizontal menu split
var cmThemeThreeHSplit = [_cmNoAction, '<td class="ThemeThreeMenuItemLeft"></td><td colspan="2"><div class="ThemeThreeMenuSplit"></div></td>'];
var cmThemeThreeMainHSplit = [_cmNoAction, '<td class="ThemeThreeMainItemLeft"></td><td colspan="2"><div class="ThemeThreeMenuSplit"></div></td>'];
var cmThemeThreeMainVSplit = [_cmNoAction, '|'];
