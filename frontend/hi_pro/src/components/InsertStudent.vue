<template>
  <div id="insertStudent">
    <label>upload excel file</label>
    <v-file-input label="File input" v-model="file" @change="previewFiles"></v-file-input>
  </div>
</template>


<script>
import XLSX from "xlsx";
export default {
  components: {},
  data() {
    return {
      file: null
    };
  },
  methods: {
    previewFiles() {
      console.log(this.file);

      // console.log("new", new Uint8Array());
      var reader = new FileReader();
      reader.onload = function() {
        var data = new Uint8Array(this.file.result);
        var workbook = XLSX.read(data, { type: "array" });
        let sheetName = workbook.SheetNames[0];
        console.log("workbook: ", workbook);
        let worksheet = workbook.Sheets[sheetName];
        console.log(XLSX.utils.sheet_to_json(worksheet));
      };
      reader.readAsArrayBuffer(this.file);

      //   f = files[0];
      // var reader = new FileReader();
      // reader.onload = function(e) {
      //   var data = new Uint8Array(e.target.result);
      //   var workbook = XLSX.read(data, { type: "array" });
      //   let sheetName = workbook.SheetNames[0];
      //   /* DO SOMETHING WITH workbook HERE */
      //   console.log(workbook);
      //   let worksheet = workbook.Sheets[sheetName];
      //   console.log(XLSX.utils.sheet_to_json(worksheet));
      // };
      // reader.readAsArrayBuffer(f);
      // console.log("Dfd", e.target.files);

      // console.log(this.metaDataFile);
    }
  }
};
</script>