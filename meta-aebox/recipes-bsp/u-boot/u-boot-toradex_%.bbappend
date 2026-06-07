# Adding the custom aebox .dtb file as fdtfiles 

do_configure:append() {
    # Remove existing fdtfile for iMX6ULL, if there is one
    sed -i '/"fdtfile=.*\\0" \\/d' ${S}/include/configs/colibri-imx6ull.h
    
    # Add new fdtfile (replace 'aebox-custom.dtb' with your custom DTS file)
    sed -i 's/\("fdt_board=.*\\0" \\\)/\0\n      "fdtfile=imx6ull-aebox-custom-board-v3.dtb\\0" \\/' ${S}/include/configs/colibri-imx6ull.h
}



