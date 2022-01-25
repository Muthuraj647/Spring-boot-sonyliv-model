
        var menubar=document.getElementById('menubar');
        var m="display:none;";
        var show=document.getElementById("nav_tab");
        let s="display:inline; top:0; right: 0;height: 380px; width: 150px; background: rgba(126, 121, 121,0.8); position: absolute; text-align: left; ";
        function showMenu()
        {
            menubar.style=m;
            show.style=s;
            
            
        }
        function closeMenu()
        {
            show.style="display:none";
            menubar.style="display:inline;"
        }
