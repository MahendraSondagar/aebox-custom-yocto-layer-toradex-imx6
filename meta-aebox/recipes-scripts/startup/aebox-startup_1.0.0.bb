SUMMARY = "aebox startup script systemD services recipe"
DESCRIPTION = "A startup script for the i.MX6 SoC"
LICENSE = "MIT"

# Specify the version of your recipe (e.g., 1.0)
SRCREV = "1.0"

# Define the recipe metadata
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd features_check
RDEPENDS:${PN} += "bash"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "aebox.service"

# Specify the location of your startup script file
SRC_URI = "file://aebox.service"
FILES:${PN} += "${systemd_unitdir}/system/aebox.service"

S = "${WORKDIR}"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/aebox.service ${D}/${systemd_unitdir}/system
}

REQUIRED_DISTRO_FEATURES = "systemd"

