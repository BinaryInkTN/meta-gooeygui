DESCRIPTION = "GooeyGUI graphics library" 
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI="gitsm://github.com/BinaryInkTN/GooeyGUI.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
DEPENDS = "\
    libx11 \
    virtual/egl \
    virtual/libgles2 \
    virtual/libgl \
    gtk+3 \
    alsa-lib \
    freetype \
    mesa \
    "
RDEPENDS:{PN} = "\
    mesa \
    libx11 \
    virtual/egl \
    virtual/libgles2 \
    virtual/libgl \
    gtk+3 \
    alsa-lib \
    freetype \
    "
PROVIDES="libgooeygui" 

S = "${WORKDIR}/git"
inherit pkgconfig  cmake 

EXTRA_OECMAKE = "\
-DUSE_BUNDLED_FREETYPE=OFF \
-DGLES_ON=ON \
"

# effacer les chaltates 
