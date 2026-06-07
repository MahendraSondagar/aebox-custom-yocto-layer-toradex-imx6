SUMMARY = "aebox custom minimal image"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

AUTHOR= "Mahendra Sondagar | mahendrasondagar08@gmail.com"

IMAGE_LINGUAS = "en-us"

LICENSE = "MIT"

inherit core-image

#start of the resulting deployable tarball name
export IMAGE_BASENAME = "Custom-Aebox-Image"
MACHINE_NAME ?= "${MACHINE}"
IMAGE_NAME = "${MACHINE_NAME}_${IMAGE_BASENAME}"

#IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

# Set rootfs to 200 MiB by default
#IMAGE_ROOTFS_MAXSIZE = "256000"  

IMAGE_FETAURES += "ssh-server-dropbear"

# add the rootfs version to the welcome banner
ROOTFS_POSTPROCESS_COMMAND += " add_rootfs_version;"


EXTRA_USERS_PARAMS += " useradd -m -s /bin/bash -P 'aebox' root;"

#Installing the supported libraries 
IMAGE_INSTALL:append = " python3 python3-pip \
                         usbutils pciutils \
                         util-linux \
                         dropbear \
                         qtserialbus \
                         qtmqtt   \
                         qtbase-plugins \
                         aebox          \
                         aebox-startup \
                       "
CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-client"

IMAGE_INSTALL += " \
    packagegroup-boot          \
    packagegroup-basic         \
    udev-extraconf             \
    packagegroup-base-tdx-cli  \
    packagegroup-devel-tdx-cli \
    packagegroup-utils-tdx-cli \
    packagegroup-tdx-qt6       \
    ${CONMANPKGS}              \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-analyze', '', d)} \
"

# EXTRA_IMAGE_FEATURES += "setuidgid"

EXTRA_IMAGE_FEATURES += "debug-tweaks"

