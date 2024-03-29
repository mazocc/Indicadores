/*
 Data plugin for Highcharts v0.1

 (c) 2012 Torstein Hønsi

 License: www.highcharts.com/license
 */
(function (h) {
    var l = h.each, m = function (a) {
        this.init(a)
    };
    h.extend(m.prototype, {init: function (a) {
        this.options = a;
        this.columns = a.columns || this.rowsToColumns(a.rows) || [];
        this.columns.length ? this.dataFound() : (this.parseCSV(), this.parseTable(), this.parseGoogleSpreadsheet())
    }, dataFound: function () {
        this.parseTypes();
        this.findHeaderRow();
        this.parsed();
        this.complete()
    }, parseCSV: function () {
        var a = this.options, b = a.csv, d = this.columns, c = a.startRow || 0, g = a.endRow || Number.MAX_VALUE, f = a.startColumn || 0, j = a.endColumn || Number.MAX_VALUE;
        b && (b = b.replace(/\r\n/g, "\n").replace(/\r/g, "\n").split(a.lineDelimiter || "\n"), l(b, function (b, k) {
            if (k >= c && k <= g) {
                var e = b.split(a.itemDelimiter || ",");
                l(e, function (a, b) {
                    b >= f && b <= j && (d[b - f] || (d[b - f] = []), d[b - f][k - c] = a)
                })
            }
        }), this.dataFound())
    }, parseTable: function () {
        var a = this.options, b = a.table, d = this.columns, c = a.startRow || 0, g = a.endRow || Number.MAX_VALUE, f = a.startColumn || 0, j = a.endColumn || Number.MAX_VALUE, i;
        b && (typeof b === "string" && (b = document.getElementById(b)), l(b.getElementsByTagName("tr"), function (a, b) {
            i =
                0;
            b >= c && b <= g && l(a.childNodes, function (a) {
                if ((a.tagName === "TD" || a.tagName === "TH") && i >= f && i <= j)d[i] || (d[i] = []), d[i][b - c] = a.innerHTML, i += 1
            })
        }), this.dataFound())
    }, parseGoogleSpreadsheet: function () {
        var a = this, b = this.options, d = b.googleSpreadsheetKey, c = this.columns;
        d && jQuery.getJSON("https://spreadsheets.google.com/feeds/cells/" + d + "/" + (b.googleSpreadsheetWorksheet || "od6") + "/public/values?alt=json-in-script&callback=?", function (b) {
            var b = b.feed.entry, d, j = b.length, i = 0, k = 0, e;
            for (e = 0; e < j; e++)d = b[e], i = Math.max(i,
                d.gs$cell.col), k = Math.max(k, d.gs$cell.row);
            for (e = 0; e < i; e++)c[e] = Array(k);
            for (e = 0; e < j; e++)d = b[e], c[d.gs$cell.col - 1][d.gs$cell.row - 1] = d.content.$t;
            a.dataFound()
        })
    }, findHeaderRow: function () {
        l(this.columns, function () {
        });
        this.headerRow = 0
    }, trim: function (a) {
        return typeof a === "string" ? a.replace(/^\s+|\s+$/g, "") : a
    }, parseTypes: function () {
        for (var a = this.columns, b = a.length, d, c, g, f; b--;)for (d = a[b].length; d--;)c = a[b][d], g = parseFloat(c), f = this.trim(c), f == g ? (a[b][d] = g, g > 31536E6 ? a[b].isDatetime = !0 : a[b].isNumeric = !0) : (c = this.parseDate(c), b === 0 && typeof c === "number" && !isNaN(c) ? (a[b][d] = c, a[b].isDatetime = !0) : a[b][d] = f)
    }, dateFormats: {"YYYY-mm-dd": {regex: "^([0-9]{4})-([0-9]{2})-([0-9]{2})$", parser: function (a) {
        return Date.UTC(+a[1], a[2] - 1, +a[3])
    }}}, parseDate: function (a) {
        var b = this.options.parseDate, d, c, g;
        b && (d = b);
        if (typeof a === "string")for (c in this.dateFormats)b = this.dateFormats[c], (g = a.match(b.regex)) && (d = b.parser(g));
        return d
    }, rowsToColumns: function (a) {
        var b, d, c, g, f;
        if (a) {
            f = [];
            d = a.length;
            for (b = 0; b < d; b++) {
                g = a[b].length;
                for (c = 0; c < g; c++)f[c] || (f[c] = []), f[c][b] = a[b][c]
            }
        }
        return f
    }, parsed: function () {
        this.options.parsed && this.options.parsed.call(this, this.columns)
    }, complete: function () {
        var a = this.columns, b, d, c, g, f = this.options, j, i, k, e, h;
        if (f.complete) {
            a.length > 1 && (c = a.shift(), this.headerRow === 0 && c.shift(), (b = c.isNumeric || c.isDatetime) || (d = c), c.isDatetime && (g = "datetime"));
            j = [];
            for (e = 0; e < a.length; e++) {
                this.headerRow === 0 && (k = a[e].shift());
                i = [];
                for (h = 0; h < a[e].length; h++)i[h] = a[e][h] !== void 0 ? b ? [c[h], a[e][h]] : a[e][h] : null;
                j[e] = {name: k, data: i}
            }
            f.complete({xAxis: {categories: d, type: g}, series: j})
        }
    }});
    h.Data = m;
    h.data = function (a) {
        return new m(a)
    };
    h.wrap(h.Chart.prototype, "init", function (a, b, d) {
        var c = this;
        b && b.data ? h.data(h.extend(b.data, {complete: function (g) {
            var f = [];
            l(g.series, function (a, b) {
                f[b] = a.data;
                a.data = null
            });
            b = h.merge(g, b);
            l(f, function (a, c) {
                b.series[c].data = a
            });
            a.call(c, b, d)
        }})) : a.call(c, b, d)
    })
})(Highcharts);
