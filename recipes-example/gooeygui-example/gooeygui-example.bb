DESCRIPTION = "GooeyGUI example recipe" 
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI="file://gooey_example.c"

FILE_NAME="gooey_example"
DEPENDS = "\
    gooeygui-libc \
   "
RDEPENDS:{PN} += " gooeygui-libc"

S = "${WORKDIR}"
inherit pkgconfig
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
do_compile(){
   ${CC} ${FILE_NAME}.c -g -O0 -o ${FILE_NAME} \
    ${LDFLAGS} \
     -I${STAGING_INCDIR}/Gooey \
     -I${STAGING_INCDIR}/GLPS \
     ${CFLAGS} \
     -lcjson -lfreetype -lGooeyGUI-1   -lGLPS   -lm 
}
do_install(){
    install -d ${D}${bindir}
    install -m 0755 ${FILE_NAME} ${D}${bindir} 
}
FILES:${PN} += "${bindir}/${FILE_NAME}"
