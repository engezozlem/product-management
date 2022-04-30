// vue.config.js
module.exports = {
    // https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        port: 3000,
        proxy: {
            '/product/api': {
                target: 'http://localhost:8081',
                ws: true,
                changeOrigin: true
            }
        }
    }
}