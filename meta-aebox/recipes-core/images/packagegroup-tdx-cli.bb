SUMMARY = "Packagegroups which provide cmdline releated packages"

DESCRIPTION = "Only required packages list for the AEBOX image"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES += " \
    packagegroup-base-tdx-cli \
    packagegroup-devel-tdx-cli \
    packagegroup-utils-tdx-cli \
"

RDEPENDS:packagegroup-tdx-cli = "\
    packagegroup-base-tdx-cli \
    packagegroup-devel-tdx-cli \
    packagegroup-utils-tdx-cli \
"

USB_GADGET = " \
    libusbgx \
    libusbgx-examples \
"

SUMMARY:packagegroup-base-tdx-cli = "Recommended for any image"
RRECOMMENDS:packagegroup-base-tdx-cli = "\
    iproute2 \
    libgomp \
    libgpiod-tools \
    mtd-utils \
    set-hostname \
    u-boot-fw-utils \
    udev-toradex-rules \
    ${USB_GADGET} \
    tdx-info \
"

SUMMARY:packagegroup-devel-tdx-cli = "Tools useful during development"
RRECOMMENDS:packagegroup-devel-tdx-cli = "\
    gdbserver \
    i2c-tools \
    serial-test \
    spitools \
    spidev-test \
    strace \
"
SUMMARY:packagegroup-utils-tdx-cli = "Useful utilities"

# Entropy source daemon
RANDOM_HELPER = "rng-tools"

RRECOMMENDS:packagegroup-utils-tdx-cli = "\
    ethtool \
    grep \
    minicom \
    mmc-utils-cos \
    pciutils \
    phytool \
    ${RANDOM_HELPER} \
    stress-ng \
    util-linux \
"






