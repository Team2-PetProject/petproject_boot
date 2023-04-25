const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave : false,
  outputDir: "../src/main/resources/static/vue",
devServer: {
proxy: {
"/": {
target: "http://localhost:8090", //back end port
changeOrigin: true,
},
},
},
})
