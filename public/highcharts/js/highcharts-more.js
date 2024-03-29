/*
 Highcharts JS v2.3.5 (2012-12-19)

 (c) 2009-2011 Torstein Hønsi

 License: www.highcharts.com/license
 */
(function (i, v) {
    function A(a, b, c) {
        this.init.call(this, a, b, c)
    }

    function B(a, b, c) {
        a.call(this, b, c);
        if (this.chart.polar)this.closeSegment = function (a) {
            var b = this.xAxis.center;
            a.push("L", b[0], b[1])
        }, this.closedStacks = !0
    }

    function C(a, b) {
        var c = this.chart, d = this.options.animation, g = this.group, f = this.markerGroup, e = this.xAxis.center, h = c.plotLeft, m = c.plotTop;
        if (c.polar) {
            if (c.renderer.isSVG)if (d === !0 && (d = {}), b) {
                if (g.attrSetters.scaleX = g.attrSetters.scaleY = function (a, b) {
                    this[b] = a;
                    this.scaleX !== v && this.scaleY !==
                        v && this.element.setAttribute("transform", "translate(" + this.translateX + "," + this.translateY + ") scale(" + this.scaleX + "," + this.scaleY + ")");
                    return!1
                }, c = {translateX: e[0] + h, translateY: e[1] + m, scaleX: 0, scaleY: 0}, g.attr(c), f)f.attrSetters = g.attrSetters, f.attr(c)
            } else c = {translateX: h, translateY: m, scaleX: 1, scaleY: 1}, g.animate(c, d), f && f.animate(c, d), this.animate = null
        } else a.call(this, b)
    }

    var q = i.each, w = i.extend, p = i.merge, G = i.map, o = i.pick, x = i.pInt, n = i.getOptions().plotOptions, j = i.seriesTypes, D = i.extendClass, E = i.splat,
        l = i.wrap, s = i.Axis, H = i.Tick, z = i.Series, r = j.column.prototype, t = function () {
        };
    w(A.prototype, {init: function (a, b, c) {
        var d = this, g = d.defaultOptions;
        d.chart = b;
        if (b.angular)g.background = {};
        d.options = a = p(g, a);
        (a = a.background) && q([].concat(E(a)).reverse(), function (a) {
            var b = a.backgroundColor, a = p(d.defaultBackgroundOptions, a);
            if (b)a.backgroundColor = b;
            a.color = a.backgroundColor;
            c.options.plotBands.unshift(a)
        })
    }, defaultOptions: {center: ["50%", "50%"], size: "85%", startAngle: 0}, defaultBackgroundOptions: {shape: "circle",
        borderWidth: 1, borderColor: "silver", backgroundColor: {linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1}, stops: [
            [0, "#FFF"],
            [1, "#DDD"]
        ]}, from: Number.MIN_VALUE, innerRadius: 0, to: Number.MAX_VALUE, outerRadius: "105%"}});
    var y = s.prototype, s = H.prototype, I = {getOffset: t, redraw: function () {
        this.isDirty = !1
    }, render: function () {
        this.isDirty = !1
    }, setScale: t, setCategories: t, setTitle: t}, F = {isRadial: !0, defaultRadialGaugeOptions: {labels: {align: "center", x: 0, y: null}, minorGridLineWidth: 0, minorTickInterval: "auto", minorTickLength: 10, minorTickPosition: "inside",
        minorTickWidth: 1, plotBands: [], tickLength: 10, tickPosition: "inside", tickWidth: 2, title: {rotation: 0}, zIndex: 2}, defaultRadialXOptions: {gridLineWidth: 1, labels: {align: null, distance: 15, x: 0, y: null}, maxPadding: 0, minPadding: 0, plotBands: [], showLastLabel: !1, tickLength: 0}, defaultRadialYOptions: {gridLineInterpolation: "circle", labels: {align: "right", x: -3, y: -2}, plotBands: [], showLastLabel: !1, title: {x: 4, text: null, rotation: 90}}, setOptions: function (a) {
        this.options = p(this.defaultOptions, this.defaultRadialOptions, a)
    }, getOffset: function () {
        y.getOffset.call(this);
        this.chart.axisOffset[this.side] = 0;
        this.center = this.pane.center = j.pie.prototype.getCenter.call(this.pane)
    }, getLinePath: function (a, b) {
        var c = this.center, b = o(b, c[2] / 2 - this.offset);
        return this.chart.renderer.symbols.arc(this.left + c[0], this.top + c[1], b, b, {start: this.startAngleRad, end: this.endAngleRad, open: !0, innerR: 0})
    }, setAxisTranslation: function () {
        y.setAxisTranslation.call(this);
        if (this.center && (this.transA = this.isCircular ? (this.endAngleRad - this.startAngleRad) / (this.max - this.min || 1) : this.center[2] / 2 /
            (this.max - this.min || 1), this.isXAxis))this.minPixelPadding = this.transA * this.minPointOffset + (this.reversed ? (this.endAngleRad - this.startAngleRad) / 4 : 0)
    }, beforeSetTickPositions: function () {
        this.autoConnect && (this.max += this.categories && 1 || this.pointRange || this.closestPointRange)
    }, setAxisSize: function () {
        y.setAxisSize.call(this);
        if (this.center)this.len = this.width = this.height = this.isCircular ? this.center[2] * (this.endAngleRad - this.startAngleRad) / 2 : this.center[2] / 2
    }, getPosition: function (a, b) {
        if (!this.isCircular)b =
            this.translate(a), a = this.min;
        return this.postTranslate(this.translate(a), o(b, this.center[2] / 2) - this.offset)
    }, postTranslate: function (a, b) {
        var c = this.chart, d = this.center, a = this.startAngleRad + a;
        return{x: c.plotLeft + d[0] + Math.cos(a) * b, y: c.plotTop + d[1] + Math.sin(a) * b}
    }, getPlotBandPath: function (a, b, c) {
        var d = this.center, g = this.startAngleRad, f = d[2] / 2, e = [o(c.outerRadius, "100%"), c.innerRadius, o(c.thickness, 10)], h = /%$/, m, k = this.isCircular;
        this.options.gridLineInterpolation === "polygon" ? d = this.getPlotLinePath(a).concat(this.getPlotLinePath(b,
            !0)) : (k || (e[0] = this.translate(a), e[1] = this.translate(b)), e = G(e, function (a) {
            h.test(a) && (a = x(a, 10) * f / 100);
            return a
        }), c.shape === "circle" || !k ? (a = -Math.PI / 2, b = Math.PI * 1.5, m = !0) : (a = g + this.translate(a), b = g + this.translate(b)), d = this.chart.renderer.symbols.arc(this.left + d[0], this.top + d[1], e[0], e[0], {start: a, end: b, innerR: o(e[1], e[0] - e[2]), open: m}));
        return d
    }, getPlotLinePath: function (a, b) {
        var c = this.center, d = this.chart, g = this.getPosition(a), f, e, h;
        this.isCircular ? h = ["M", c[0] + d.plotLeft, c[1] + d.plotTop, "L", g.x,
            g.y] : this.options.gridLineInterpolation === "circle" ? (a = this.translate(a)) && (h = this.getLinePath(0, a)) : (f = d.xAxis[0], h = [], a = this.translate(a), c = f.tickPositions, f.autoConnect && (c = c.concat([c[0]])), b && (c = [].concat(c).reverse()), q(c, function (b, c) {
            e = f.getPosition(b, a);
            h.push(c ? "L" : "M", e.x, e.y)
        }));
        return h
    }, getTitlePosition: function () {
        var a = this.center, b = this.chart, c = this.options.title;
        return{x: b.plotLeft + a[0] + (c.x || 0), y: b.plotTop + a[1] - {high: 0.5, middle: 0.25, low: 0}[c.align] * a[2] + (c.y || 0)}
    }};
    l(y, "init", function (a, b, c) {
        var d = b.angular, g = b.polar, f = c.isX, e = d && f, h, m;
        m = b.options;
        var k = c.pane || 0;
        if (d) {
            if (w(this, e ? I : F), h = !f)this.defaultRadialOptions = this.defaultRadialGaugeOptions
        } else if (g)w(this, F), this.defaultRadialOptions = (h = f) ? this.defaultRadialXOptions : p(this.defaultYAxisOptions, this.defaultRadialYOptions);
        a.call(this, b, c);
        if (!e && (d || g)) {
            a = this.options;
            if (!b.panes)b.panes = [];
            this.pane = b.panes[k] = k = new A(E(m.pane)[k], b, this);
            k = k.options;
            b.inverted = !1;
            m.chart.zoomType = null;
            this.startAngleRad = b = (k.startAngle - 90) *
                Math.PI / 180;
            this.endAngleRad = m = (o(k.endAngle, k.startAngle + 360) - 90) * Math.PI / 180;
            this.offset = a.offset || 0;
            if ((this.isCircular = h) && c.max === v && m - b === 2 * Math.PI)this.autoConnect = !0
        }
    });
    l(s, "getPosition", function (a, b, c, d, g) {
        var f = this.axis;
        return f.getPosition ? f.getPosition(c) : a.call(this, b, c, d, g)
    });
    l(s, "getLabelPosition", function (a, b, c, d, g, f, e, h, m) {
        var k = this.axis, i = f.y, j = f.align, l = (k.translate(this.pos) + k.startAngleRad + Math.PI / 2) / Math.PI * 180;
        k.isRadial ? (a = k.getPosition(this.pos, k.center[2] / 2 + o(f.distance,
            -25)), f.rotation === "auto" ? d.attr({rotation: l}) : i === null && (i = x(d.styles.lineHeight) * 0.9 - d.getBBox().height / 2), j === null && (j = k.isCircular ? l > 20 && l < 160 ? "left" : l > 200 && l < 340 ? "right" : "center" : "center", d.attr({align: j})), a.x += f.x, a.y += i) : a = a.call(this, b, c, d, g, f, e, h, m);
        return a
    });
    l(s, "getMarkPath", function (a, b, c, d, g, f, e) {
        var h = this.axis;
        h.isRadial ? (a = h.getPosition(this.pos, h.center[2] / 2 + d), b = ["M", b, c, "L", a.x, a.y]) : b = a.call(this, b, c, d, g, f, e);
        return b
    });
    n.arearange = p(n.area, {lineWidth: 1, marker: null, threshold: null,
        tooltip: {pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.low}</b> - <b>{point.high}</b><br/>'}, trackByArea: !0, dataLabels: {verticalAlign: null, xLow: 0, xHigh: 0, yLow: 0, yHigh: 0}, shadow: !1});
    s = i.extendClass(i.Point, {applyOptions: function (a, b) {
        var c = this.series, d = c.pointArrayMap, g = 0, f = 0, e = d.length;
        if (typeof a === "object" && typeof a.length !== "number")w(this, a), this.options = a; else if (a.length) {
            if (a.length > e) {
                if (typeof a[0] === "string")this.name = a[0]; else if (typeof a[0] === "number")this.x =
                    a[0];
                g++
            }
            for (; f < e;)this[d[f++]] = a[g++]
        }
        this.y = this[c.pointValKey];
        if (this.x === v && c)this.x = b === v ? c.autoIncrement() : b;
        return this
    }, toYData: function () {
        return[this.low, this.high]
    }});
    j.arearange = i.extendClass(j.area, {type: "arearange", pointArrayMap: ["low", "high"], pointClass: s, pointValKey: "low", translate: function () {
        var a = this.yAxis;
        j.area.prototype.translate.apply(this);
        q(this.points, function (b) {
            if (b.y !== null)b.plotLow = b.plotY, b.plotHigh = a.translate(b.high, 0, 1, 0, 1)
        })
    }, getSegmentPath: function (a) {
        var b = [],
            c = a.length, d = z.prototype.getSegmentPath, g, f;
        f = this.options;
        for (var e = f.step; c--;)g = a[c], b.push({plotX: g.plotX, plotY: g.plotHigh});
        a = d.call(this, a);
        if (e)e === !0 && (e = "left"), f.step = {left: "right", center: "center", right: "left"}[e];
        b = d.call(this, b);
        f.step = e;
        f = [].concat(a, b);
        b[0] = "L";
        this.areaPath = this.areaPath.concat(a, b);
        return f
    }, drawDataLabels: function () {
        var a = this.data, b = a.length, c, d = [], g = z.prototype, f = this.options.dataLabels, e, h = this.chart.inverted;
        if (f.enabled || this._hasPointLabels) {
            for (c = b; c--;)e =
                a[c], e.y = e.high, e.plotY = e.plotHigh, d[c] = e.dataLabel, e.dataLabel = e.dataLabelUpper, e.below = !1, h ? (f.align = "left", f.x = f.xHigh) : f.y = f.yHigh;
            g.drawDataLabels.apply(this, arguments);
            for (c = b; c--;)e = a[c], e.dataLabelUpper = e.dataLabel, e.dataLabel = d[c], e.y = e.low, e.plotY = e.plotLow, e.below = !0, h ? (f.align = "right", f.x = f.xLow) : f.y = f.yLow;
            g.drawDataLabels.apply(this, arguments)
        }
    }, alignDataLabel: j.column.prototype.alignDataLabel, getSymbol: j.column.prototype.getSymbol, drawPoints: t});
    n.areasplinerange = p(n.arearange);
    j.areasplinerange =
        D(j.arearange, {type: "areasplinerange", getPointSpline: j.spline.prototype.getPointSpline});
    n.columnrange = p(n.column, n.arearange, {lineWidth: 1, pointRange: null});
    j.columnrange = D(j.arearange, {type: "columnrange", translate: function () {
        var a = this.yAxis, b;
        r.translate.apply(this);
        q(this.points, function (c) {
            var d = c.shapeArgs;
            c.plotHigh = b = a.translate(c.high, 0, 1, 0, 1);
            c.plotLow = c.plotY;
            d.y = b;
            d.height = c.plotY - b;
            c.trackerArgs = d
        })
    }, drawGraph: t, pointAttrToOptions: r.pointAttrToOptions, drawPoints: r.drawPoints, drawTracker: r.drawTracker,
        animate: r.animate});
    n.gauge = p(n.line, {dataLabels: {enabled: !0, y: 15, borderWidth: 1, borderColor: "silver", borderRadius: 3, style: {fontWeight: "bold"}, verticalAlign: "top", zIndex: 2}, dial: {}, pivot: {}, tooltip: {headerFormat: ""}, showInLegend: !1});
    n = {type: "gauge", pointClass: i.extendClass(i.Point, {setState: function (a) {
        this.state = a
    }}), angular: !0, translate: function () {
        var a = this, b = a.yAxis, c = b.center;
        a.generatePoints();
        q(a.points, function (d) {
            var g = p(a.options.dial, d.dial), f = x(o(g.radius, 80)) * c[2] / 200, e = x(o(g.baseLength,
                70)) * f / 100, h = x(o(g.rearLength, 10)) * f / 100, m = g.baseWidth || 3, k = g.topWidth || 1;
            d.shapeType = "path";
            d.shapeArgs = {d: g.path || ["M", -h, -m / 2, "L", e, -m / 2, f, -k / 2, f, k / 2, e, m / 2, -h, m / 2, "z"], translateX: c[0], translateY: c[1], rotation: (b.startAngleRad + b.translate(d.y, null, null, null, !0)) * 180 / Math.PI};
            d.plotX = c[0];
            d.plotY = c[1]
        })
    }, drawPoints: function () {
        var a = this, b = a.yAxis.center, c = a.pivot, d = a.options, g = d.pivot, f = a.chart.renderer;
        q(a.points, function (b) {
            var c = b.graphic, g = b.shapeArgs, k = g.d, i = p(d.dial, b.dial);
            c ? (c.animate(g),
                g.d = k) : b.graphic = f[b.shapeType](g).attr({stroke: i.borderColor || "none", "stroke-width": i.borderWidth || 0, fill: i.backgroundColor || "black", rotation: g.rotation}).add(a.group)
        });
        c ? c.animate({translateX: b[0], translateY: b[1]}) : a.pivot = f.circle(0, 0, o(g.radius, 5)).attr({"stroke-width": g.borderWidth || 0, stroke: g.borderColor || "silver", fill: g.backgroundColor || "black"}).translate(b[0], b[1]).add(a.group)
    }, animate: function () {
        var a = this;
        q(a.points, function (b) {
            var c = b.graphic;
            c && (c.attr({rotation: a.yAxis.startAngleRad *
                180 / Math.PI}), c.animate({rotation: b.shapeArgs.rotation}, a.options.animation))
        });
        a.animate = null
    }, render: function () {
        this.group = this.plotGroup("group", "series", this.visible ? "visible" : "hidden", this.options.zIndex, this.chart.seriesGroup);
        j.pie.prototype.render.call(this);
        this.group.clip(this.chart.clipRect)
    }, setData: j.pie.prototype.setData, drawTracker: j.column.prototype.drawTracker};
    j.gauge = i.extendClass(j.line, n);
    var u = z.prototype, n = i.MouseTracker.prototype;
    u.toXY = function (a) {
        var b, c = this.chart;
        b = a.plotX;
        var d = a.plotY;
        a.rectPlotX = b;
        a.rectPlotY = d;
        a.deg = b / Math.PI * 180;
        b = this.xAxis.postTranslate(a.plotX, this.yAxis.len - d);
        a.plotX = a.polarPlotX = b.x - c.plotLeft;
        a.plotY = a.polarPlotY = b.y - c.plotTop
    };
    l(j.area.prototype, "init", B);
    l(j.areaspline.prototype, "init", B);
    l(j.spline.prototype, "getPointSpline", function (a, b, c, d) {
        var g, f, e, h, i, k, j;
        if (this.chart.polar) {
            g = c.plotX;
            f = c.plotY;
            a = b[d - 1];
            e = b[d + 1];
            this.connectEnds && (a || (a = b[b.length - 2]), e || (e = b[1]));
            if (a && e)h = a.plotX, i = a.plotY, b = e.plotX, k = e.plotY, h = (1.5 * g + h) / 2.5,
                i = (1.5 * f + i) / 2.5, e = (1.5 * g + b) / 2.5, j = (1.5 * f + k) / 2.5, b = Math.sqrt(Math.pow(h - g, 2) + Math.pow(i - f, 2)), k = Math.sqrt(Math.pow(e - g, 2) + Math.pow(j - f, 2)), h = Math.atan2(i - f, h - g), i = Math.atan2(j - f, e - g), j = Math.PI / 2 + (h + i) / 2, Math.abs(h - j) > Math.PI / 2 && (j -= Math.PI), h = g + Math.cos(j) * b, i = f + Math.sin(j) * b, e = g + Math.cos(Math.PI + j) * k, j = f + Math.sin(Math.PI + j) * k, c.rightContX = e, c.rightContY = j;
            d ? (c = ["C", a.rightContX || a.plotX, a.rightContY || a.plotY, h || g, i || f, g, f], a.rightContX = a.rightContY = null) : c = ["M", g, f]
        } else c = a.call(this, b, c, d);
        return c
    });
    l(u, "translate", function (a) {
        a.call(this);
        if (this.chart.polar && !this.preventPostTranslate)for (var a = this.points, b = a.length; b--;)this.toXY(a[b])
    });
    l(u, "getSegmentPath", function (a, b) {
        var c = this.points;
        if (this.chart.polar && this.options.connectEnds !== !1 && b[b.length - 1] === c[c.length - 1] && c[0].y !== null)this.connectEnds = !0, b = [].concat(b, [c[0]]);
        return a.call(this, b)
    });
    l(u, "animate", C);
    l(r, "animate", C);
    l(u, "setTooltipPoints", function (a, b) {
        this.chart.polar && w(this.xAxis, {tooltipLen: 360, tooltipPosName: "deg"});
        return a.call(this, b)
    });
    l(r, "translate", function (a) {
        var b = this.xAxis, c = this.yAxis.len, d = b.center, g = b.startAngleRad, f = this.chart.renderer, e, h;
        this.preventPostTranslate = !0;
        a.call(this);
        if (b.isRadial) {
            b = this.points;
            for (h = b.length; h--;)e = b[h], a = e.barX + g, e.shapeType = "path", e.shapeArgs = {d: f.symbols.arc(d[0], d[1], c - e.plotY, null, {start: a, end: a + e.pointWidth, innerR: c - o(e.yBottom, c)})}, this.toXY(e)
        }
    });
    l(r, "alignDataLabel", function (a, b, c, d, g, f) {
        if (this.chart.polar) {
            a = b.rectPlotX / Math.PI * 180;
            if (d.align === null)d.align =
                a > 20 && a < 160 ? "left" : a > 200 && a < 340 ? "right" : "center";
            if (d.verticalAlign === null)d.verticalAlign = a < 45 || a > 315 ? "bottom" : a > 135 && a < 225 ? "top" : "middle";
            u.alignDataLabel.call(this, b, c, d, g, f)
        } else a.call(this, b, c, d, g, f)
    });
    l(n, "getIndex", function (a, b) {
        var c, d = this.chart, g;
        d.polar ? (g = d.xAxis[0].center, c = b.chartX - g[0] - d.plotLeft, d = b.chartY - g[1] - d.plotTop, c = 180 - Math.round(Math.atan2(c, d) / Math.PI * 180)) : c = a.call(this, b);
        return c
    });
    l(n, "getMouseCoordinates", function (a, b) {
        var c = this.chart, d = {xAxis: [], yAxis: []};
        c.polar ?
            q(c.axes, function (a) {
                var f = a.isXAxis, e = a.center, h = b.chartX - e[0] - c.plotLeft, e = b.chartY - e[1] - c.plotTop;
                d[f ? "xAxis" : "yAxis"].push({axis: a, value: a.translate(f ? Math.PI - Math.atan2(h, e) : Math.sqrt(Math.pow(h, 2) + Math.pow(e, 2)), !0)})
            }) : d = a.call(this, b);
        return d
    })
})(Highcharts);
