function winOpen (strURL,strName,width,height)
{
    theWindow = window.open (strURL,strName,"width="+width+" height="+height+" scrollbars=yes left="+(1024-width)/2+" top="+(768-height)/2);	
    if (theWindow.opener == null) theWindow.opener = window;
    if (window.focus) theWindow.focus();
}