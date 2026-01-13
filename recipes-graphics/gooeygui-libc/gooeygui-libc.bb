DESCRIPTION = "GooeyGUI graphics library" 
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI="gitsm://github.com/BinaryInkTN/GooeyGUI.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
DEPENDS = "\
    libx11 \
    virtual/egl \
    virtual/libgles2 \
    gtk+3 \
    alsa-lib \
    freetype \
    mesa \
    pkgconfig-native \
"
RDEPENDS:${PN} += "mesa-megadriver libgles2-mesa libegl-mesa"


S = "${WORKDIR}/git"
inherit pkgconfig  cmake 


FILES:${PN} += "${libdir}/*.so*"
FILES:${PN}-dev += "${includedir}/Gooey/*"

EXTRA_OECMAKE = "\
-DGLES_ON=ON \
-DUSE_BUNDLED_FREETYPE=OFF \
"


