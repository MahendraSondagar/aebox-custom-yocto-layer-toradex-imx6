FILESEXTRAPATHS:prepend := "${THISDIR}:"

CUSTOM_DEVICETREE = "imx6ull-aebox-custom-board-v3.dts"

SRC_URI += " \
    file://${CUSTOM_DEVICETREE}  \
    file://0001-imx6ull-colibri-p-req-uart6-added-dtsi.patch \
    file://0003-imx6ull-colibri-eval-v3-uart-6-enabled-dtsi.patch \
"

# Copy the custom device tree into the main-line kernel source dir before patches are applied
# Copying the custom device tree in to the main-line kernel source dir
do_configure:append() {
    # For arm32 bit devices
     cp ${WORKDIR}/${CUSTOM_DEVICETREE} ${S}/arch/arm/boot/dts
}
