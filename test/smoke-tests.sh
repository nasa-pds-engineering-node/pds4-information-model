# Simple bash script to clone a couple dLDDs and run LDDTool
#
# NOTE: Requires execution from top-level of repo, and the
# pds4-information-model package has been built already

if [ ! -f model-lddtool/target/lddtool*.tar.gz ]; then
    echo "ERROR: LDDTool tar.gz does not exist. Please build LDDTool first."
    echo
    echo "       mvn package"
    exit 1
fi

# Cleanup
rm -fr ldd-repo/ lddtool-pkg/

# Unpack lddtool
mkdir lddtool-pkg
tar -xvzf model-lddtool/target/lddtool*.tar.gz -C lddtool-pkg/

echo "Test 1: ldd-template"
git clone git@github.com:pds-data-dictionaries/ldd-template.git ldd-repo/

# Run lddtool
lddtool-pkg/lddtool*/bin/lddtool -lpJ -V 1L00 ldd-repo/src/*IngestLDD.xml

if [ $? -ne 0 ]; then
    echo "Test 1: FAILED"
    exit $?
fi

echo "Test 2: ldd-cart"
rm -fr ldd-repo
git clone git@github.com:pds-data-dictionaries/ldd-cart.git ldd-repo/

cd ldd-repo/; git submodule update --init --force --remote; cd ..

# Run lddtool
lddtool-pkg/lddtool*/bin/lddtool -lpJ -V 1L00 ldd-repo/src/*IngestLDD.xml ldd-repo/src/dependencies/ldd-*/src/*IngestLDD.xml

exit $?