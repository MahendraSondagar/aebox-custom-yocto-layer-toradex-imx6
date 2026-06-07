SUMMARY = "Recipe to extract and install aebox.tar.xz to /opt directory"
LICENSE = "CLOSED"

# Define the file path for the source tarball
SRC_URI = "file://aebox.tar.xz;unpack=0"

# Set the source directory after extraction
S = "${WORKDIR}"

# Add runtime dependencies
RDEPENDS:${PN} += "qtbase-plugins qtserialport qtmqtt qtserialbus qtbase bash"

# Define where the extracted files will be installed
do_install() {
    echo "Installing aebox..."

    # Create the target installation directory in /opt
    install -d ${D}/opt/aebox

    # Extract all contents of the tarball directly into /opt/aebox
    tar -xf ${S}/aebox.tar.xz -C ${D}/opt/aebox

    # Change ownership of all files to root to avoid host contamination
    chown -R root:root ${D}/opt/aebox

    echo "Installation completed."
}

# Ensure the files get packaged correctly
FILES:${PN} += "/opt/aebox"

