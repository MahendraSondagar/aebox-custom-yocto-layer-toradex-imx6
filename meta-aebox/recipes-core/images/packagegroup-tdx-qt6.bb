SUMMARY = "Packagegroup which provides most QT6 libraries"

DESCRIPTION = "QT6 layers for the custom AEBOX image"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES += " \
    ${PN}-demos \
    ${PN}-fonts \
    ${PN}-libs \
"

RRECOMMENDS:${PN} = " \
    ${PN}-demos \
    ${PN}-fonts \
    ${PN}-libs \
"

# Only install qtbase-examples with its dependencies on modules with limited
# storage and no gpu.
RRECOMMENDS:${PN}:colibri-imx6ull = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtbase-examples \
"
RRECOMMENDS:${PN}:colibri-imx6ull-emmc = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtbase-examples \
"
RRECOMMENDS:${PN}:colibri-imx7 = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtbase-examples \
"


SUMMARY:${PN}-fonts = "Some fonts useful for QT6"
RRECOMMENDS:${PN}-fonts = " \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
"

SUMMARY:${PN}-libs = "QT6 libraries"
RRECOMMENDS:${PN}-libs = " \
    qt3d \
    qtbase \
    qtcharts \
    qtconnectivity \
    qtdeclarative \
    qtimageformats \
    qtmqtt \
    qtmultimedia \
    qtnetworkauth \
    qtscxml \
    qtsensors \
    qtserialbus \
    qtserialport \
    qttools \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
"

