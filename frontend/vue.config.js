const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir : '../src/main/resources/static/vue',
  devServer : {
    proxy : {
      "/" : {
        target : "http://localhost:8096",
        changeOrigin : true
      },
    },
  },
})
