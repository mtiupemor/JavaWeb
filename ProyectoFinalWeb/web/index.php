<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" href="css/joint.css" />
        <link rel="stylesheet" href="css/devs.css" />
        <script src="js/joint.js"></script>        
        <script src="js/joint.shapes.devs.min.js"></script>
        <script src="js/joint.shapes.devs.js"></script>
        <script>
            $(document).ready(function(){
                /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var graph = new joint.dia.Graph;

var paper = new joint.dia.Paper({
    el: $('#paper'),
    width: 800,
    height: 600,
    gridSize: 1,
    model: graph,
    snapLinks: true,
    embeddingMode: true,
    validateEmbedding: function(childView, parentView) {
        return parentView.model instanceof joint.shapes.devs.Coupled;
    },
    validateConnection: function(sourceView, sourceMagnet, targetView, targetMagnet) {
        return sourceMagnet != targetMagnet;
    }
});

var connect = function(source, sourcePort, target, targetPort) {
    var link = new joint.shapes.devs.Link({
        source: { id: source.id, selector: source.getPortSelector(sourcePort) },
        target: { id: target.id, selector: target.getPortSelector(targetPort) }
    });
    link.addTo(graph).reparent();
};

var c1 = new joint.shapes.devs.Coupled({
    position: { x: 260, y: 150 },
    size: { width: 300, height: 300 },
    inPorts: ['in'],
    outPorts: ['out 1','out 2']
});

var a1 = new joint.shapes.devs.Atomic({
    position: { x: 360, y: 360 },
    inPorts: ['xy'],
    outPorts: ['x','y']
});

var a2 = new joint.shapes.devs.Atomic({
    position: { x: 50, y: 260 },
    outPorts: ['out']
});

var a3 = new joint.shapes.devs.Atomic({
    position: { x: 650, y: 150 },
    size: { width: 100, height: 300 },
    inPorts: ['a','b']
});

graph.addCells([c1, a1, a2, a3]);


connect(a2,'out',c1,'in');
connect(c1,'in',a1,'xy');
connect(a1,'x',c1,'out 1');
connect(a1,'y',c1,'out 2');
connect(c1,'out 1',a3,'a');
connect(c1,'out 2',a3,'b');

/* rounded corners */

_.each([c1,a1,a2,a3], function(element) {
    element.attr({ '.body': { 'rx': 6, 'ry': 6 }});
});

/* custom highlighting */

var highlighter = V('circle', {
    'r': 14,
    'stroke': '#ff7e5d',
    'stroke-width': '6px',
    'fill': 'transparent',
    'pointer-events': 'none'
});

paper.off('cell:highlight cell:unhighlight').on({
    
    'cell:highlight': function(cellView, el, opt) {

        if (opt.embedding) {
            V(el).addClass('highlighted-parent');
        }

        if (opt.connecting) {
            var bbox = V(el).bbox(false, paper.viewport);
            highlighter.translate(bbox.x + 10, bbox.y + 10, { absolute: true });
            V(paper.viewport).append(highlighter);
        }
    },
    
    'cell:unhighlight': function(cellView, el, opt) {

        if (opt.embedding) {
            V(el).removeClass('highlighted-parent');
        }

        if (opt.connecting) {
            highlighter.remove();
        }
    }
});



               
            });
        </script>
    </head>
    <body>
       <div id="paper">
           
       </div>
        <div>
            <img src="/images/and.png"/>
            </div>
    </body>
</html>
